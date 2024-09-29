package com.manage.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.admin.service.Admin_SemesterResultsService;
import com.manage.student.entities.SemesterResults;

@Controller
@RequestMapping("/admin/semester-results")
public class Admin_SemesterResultsController {

    private final Admin_SemesterResultsService adminSemesterResultsService;

    @Autowired
    public Admin_SemesterResultsController(@Qualifier("adminSemesterResultsServiceImpl") Admin_SemesterResultsService adminSemesterResultsService) {
        this.adminSemesterResultsService = adminSemesterResultsService;
    }

    @GetMapping
    public ModelAndView listSemesterResults(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<SemesterResults> semesterResults = adminSemesterResultsService.getAllSemesterResults();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-results");
        mav.addObject("semesterResults", semesterResults);
        return mav;
    }

    @GetMapping("/{studentId}/{semester}/{subjectCode}")
    public ModelAndView showSemesterResultsDetails(@PathVariable Long studentId, 
                                                   @PathVariable Integer semester, 
                                                   @PathVariable String subjectCode, 
                                                   HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        SemesterResults.IdClass id = new SemesterResults.IdClass(studentId, semester, subjectCode);
        SemesterResults semesterResults = adminSemesterResultsService.getSemesterResultsById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-results-details");
        mav.addObject("semesterResults", semesterResults);
        return mav;
    }

    @GetMapping("/{studentId}/{semester}/{subjectCode}/edit")
    public ModelAndView showEditSemesterResultsForm(@PathVariable Long studentId, 
                                                    @PathVariable Integer semester, 
                                                    @PathVariable String subjectCode, 
                                                    HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        SemesterResults.IdClass id = new SemesterResults.IdClass(studentId, semester, subjectCode);
        SemesterResults semesterResults = adminSemesterResultsService.getSemesterResultsById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-results-edit");
        mav.addObject("semesterResults", semesterResults);
        return mav;
    }

    @PostMapping("/{studentId}/{semester}/{subjectCode}/edit")
    public String updateSemesterResults(@PathVariable Long studentId, 
                                         @PathVariable Integer semester, 
                                         @PathVariable String subjectCode, 
                                         @ModelAttribute("semesterResults") SemesterResults semesterResults, 
                                         HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        SemesterResults.IdClass id = new SemesterResults.IdClass(studentId, semester, subjectCode);
        semesterResults.setStudentId(studentId);
        semesterResults.setSemester(semester);
        semesterResults.setSubjectCode(subjectCode);
        adminSemesterResultsService.updateSemesterResults(semesterResults);
        return "redirect:/admin/semester-results/{studentId}/{semester}/{subjectCode}";
    }

    @GetMapping("/{studentId}/{semester}/{subjectCode}/delete")
    public String deleteSemesterResults(@PathVariable Long studentId, 
                                         @PathVariable Integer semester, 
                                         @PathVariable String subjectCode, 
                                         HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        SemesterResults.IdClass id = new SemesterResults.IdClass(studentId, semester, subjectCode);
        adminSemesterResultsService.deleteSemesterResults(id);
        return "redirect:/admin/semester-results";
    }

    @GetMapping("/new")
    public ModelAndView showNewSemesterResultsForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-results-new");
        mav.addObject("semesterResults", new SemesterResults());
        return mav;
    }


    @PostMapping("/new")
    public String saveSemesterResults(
        @ModelAttribute("semesterResults") @Validated SemesterResults semesterResults, 
        BindingResult result, HttpSession session) {

        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        if (result.hasErrors()) {
            return "JSP/ADMIN/admin-semester-results-new"; // or admin-semester-summary-new
        }

        adminSemesterResultsService.saveSemesterResults(semesterResults);
        return "redirect:/admin/semester-results";
    }

}
