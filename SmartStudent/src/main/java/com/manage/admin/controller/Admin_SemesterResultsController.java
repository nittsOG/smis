package com.manage.admin.controller;

import com.manage.admin.service.Admin_SemesterResultsService;
import com.manage.student.entities.SemesterResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public ModelAndView showSemesterResultsDetails(@PathVariable Integer studentId, 
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
    public ModelAndView showEditSemesterResultsForm(@PathVariable Integer studentId, 
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
    public String updateSemesterResults(@PathVariable Integer studentId, 
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
    public String deleteSemesterResults(@PathVariable Integer studentId, 
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
    public String saveSemesterResults(@ModelAttribute("semesterResults") SemesterResults semesterResults, 
                                      HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterResultsService.saveSemesterResults(semesterResults);
        return "redirect:/admin/semester-results";
    }
}
