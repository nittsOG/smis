package com.manage.manager.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.manager.service.Manager_SemesterSummaryService;
import com.manage.student.entities.SemesterSummary;

@Controller
@RequestMapping("/manager/semester-summaries")
public class Manager_SemesterSummaryController {

    private final Manager_SemesterSummaryService managerSemesterSummaryService;

    @Autowired
    public Manager_SemesterSummaryController(@Qualifier("managerSemesterSummaryServiceImpl") Manager_SemesterSummaryService managerSemesterSummaryService) {
        this.managerSemesterSummaryService = managerSemesterSummaryService;
    }

    @GetMapping
    public ModelAndView listSemesterSummaries(HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<SemesterSummary> semesterSummaries = managerSemesterSummaryService.getAllSemesterSummaries();
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-semester-summaries");
        mav.addObject("semesterSummaries", semesterSummaries);
        return mav;
    }

    @GetMapping("/{studentId}/{semester}")
    public ModelAndView showSemesterSummaryDetails(@PathVariable Long studentId, @PathVariable Integer semester, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        SemesterSummary semesterSummary = managerSemesterSummaryService.getSemesterSummaryById(studentId, semester);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-semester-summary-details");
        mav.addObject("semesterSummary", semesterSummary);
        return mav;
    }

    @GetMapping("/{studentId}/{semester}/edit")
    public ModelAndView showEditSemesterSummaryForm(@PathVariable Long studentId, @PathVariable Integer semester, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        SemesterSummary semesterSummary = managerSemesterSummaryService.getSemesterSummaryById(studentId, semester);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-semester-summary-edit");
        mav.addObject("semesterSummary", semesterSummary);
        return mav;
    }

    @PostMapping("/{studentId}/{semester}/edit")
    public String updateSemesterSummary(@PathVariable Integer studentId, @PathVariable Integer semester, @ModelAttribute("semesterSummary") SemesterSummary semesterSummary, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        managerSemesterSummaryService.updateSemesterSummary(semesterSummary);
        return "redirect:/manager/semester-summaries/{studentId}/{semester}";
    }

    @GetMapping("/{studentId}/{semester}/delete")
    public String deleteSemesterSummary(@PathVariable Long studentId, @PathVariable Integer semester, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        managerSemesterSummaryService.deleteSemesterSummary(studentId, semester);
        return "redirect:/manager/semester-summaries";
    }
}
