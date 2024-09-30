package com.manage.manager.controller;

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

import com.manage.manager.service.Manager_SemesterResultsService;
import com.manage.student.entities.SemesterResults;

@Controller
@RequestMapping("/manager/semester-results")
public class Manager_SemesterResultsController {

    private final Manager_SemesterResultsService managerSemesterResultsService;

    @Autowired
    public Manager_SemesterResultsController(@Qualifier("managerSemesterResultsServiceImpl") Manager_SemesterResultsService managerSemesterResultsService) {
        this.managerSemesterResultsService = managerSemesterResultsService;
    }

    @GetMapping
    public ModelAndView listSemesterResults(HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<SemesterResults> semesterResults = managerSemesterResultsService.getAllSemesterResults();
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-semester-results");
        mav.addObject("semesterResults", semesterResults);
        return mav;
    }

    @GetMapping("/{studentId}/{semester}/{subjectCode}")
    public ModelAndView showSemesterResultsDetails(@PathVariable Long studentId, 
                                                   @PathVariable Integer semester, 
                                                   @PathVariable String subjectCode, 
                                                   HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        SemesterResults.IdClass id = new SemesterResults.IdClass(studentId, semester, subjectCode);
        SemesterResults semesterResults = managerSemesterResultsService.getSemesterResultsById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-semester-results-details");
        mav.addObject("semesterResults", semesterResults);
        return mav;
    }

    @GetMapping("/{studentId}/{semester}/{subjectCode}/edit")
    public ModelAndView showEditSemesterResultsForm(@PathVariable Long studentId, 
                                                    @PathVariable Integer semester, 
                                                    @PathVariable String subjectCode, 
                                                    HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        SemesterResults.IdClass id = new SemesterResults.IdClass(studentId, semester, subjectCode);
        SemesterResults semesterResults = managerSemesterResultsService.getSemesterResultsById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-semester-results-edit");
        mav.addObject("semesterResults", semesterResults);
        return mav;
    }

    @PostMapping("/{studentId}/{semester}/{subjectCode}/edit")
    public String updateSemesterResults(@PathVariable Long studentId, 
                                         @PathVariable Integer semester, 
                                         @PathVariable String subjectCode, 
                                         @ModelAttribute("semesterResults") SemesterResults semesterResults, 
                                         HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        SemesterResults.IdClass id = new SemesterResults.IdClass(studentId, semester, subjectCode);
        semesterResults.setStudentId(studentId);
        semesterResults.setSemester(semester);
        semesterResults.setSubjectCode(subjectCode);
        managerSemesterResultsService.updateSemesterResults(semesterResults);
        return "redirect:/manager/semester-results/{studentId}/{semester}/{subjectCode}";
    }

    @GetMapping("/{studentId}/{semester}/{subjectCode}/delete")
    public String deleteSemesterResults(@PathVariable Long studentId, 
                                         @PathVariable Integer semester, 
                                         @PathVariable String subjectCode, 
                                         HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        SemesterResults.IdClass id = new SemesterResults.IdClass(studentId, semester, subjectCode);
        managerSemesterResultsService.deleteSemesterResults(id);
        return "redirect:/manager/semester-results";
    }

    @GetMapping("/new")
    public ModelAndView showNewSemesterResultsForm(HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-semester-results-new");
        mav.addObject("semesterResults", new SemesterResults());
        return mav;
    }

    @PostMapping("/new")
    public String saveSemesterResults(
        @ModelAttribute("semesterResults") @Validated SemesterResults semesterResults, 
        BindingResult result, HttpSession session) {

        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        if (result.hasErrors()) {
            return "JSP/MANAGER/manager-semester-results-new";
        }

        managerSemesterResultsService.saveSemesterResults(semesterResults);
        return "redirect:/manager/semester-results";
    }

}
