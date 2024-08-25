package com.manage.admin.controller;

import com.manage.admin.service.Admin_SemesterSummaryService;
import com.manage.student.entities.SemesterSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/semester-summaries")
public class Admin_SemesterSummaryController {

    private final Admin_SemesterSummaryService adminSemesterSummaryService;

    @Autowired
    public Admin_SemesterSummaryController(@Qualifier("adminSemesterSummaryServiceImpl") Admin_SemesterSummaryService adminSemesterSummaryService) {
        this.adminSemesterSummaryService = adminSemesterSummaryService;
    }

    @GetMapping
    public ModelAndView listSemesterSummaries(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<SemesterSummary> semesterSummaries = adminSemesterSummaryService.getAllSemesterSummaries();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-summaries");
        mav.addObject("semesterSummaries", semesterSummaries);
        return mav;
    }

    @GetMapping("/{studentId}/{semester}")
    public ModelAndView showSemesterSummaryDetails(@PathVariable Integer studentId, @PathVariable Integer semester, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        SemesterSummary semesterSummary = adminSemesterSummaryService.getSemesterSummaryById(studentId, semester);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-summary-details");
        mav.addObject("semesterSummary", semesterSummary);
        return mav;
    }

    @GetMapping("/{studentId}/{semester}/edit")
    public ModelAndView showEditSemesterSummaryForm(@PathVariable Integer studentId, @PathVariable Integer semester, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        SemesterSummary semesterSummary = adminSemesterSummaryService.getSemesterSummaryById(studentId, semester);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-summary-edit");
        mav.addObject("semesterSummary", semesterSummary);
        return mav;
    }

    @PostMapping("/{studentId}/{semester}/edit")
    public String updateSemesterSummary(@PathVariable Integer studentId, @PathVariable Integer semester, @ModelAttribute("semesterSummary") SemesterSummary semesterSummary, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterSummaryService.updateSemesterSummary(semesterSummary);
        return "redirect:/admin/semester-summaries/{studentId}/{semester}";
    }

    @GetMapping("/{studentId}/{semester}/delete")
    public String deleteSemesterSummary(@PathVariable Integer studentId, @PathVariable Integer semester, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterSummaryService.deleteSemesterSummary(studentId, semester);
        return "redirect:/admin/semester-summaries";
    }

    @GetMapping("/new")
    public ModelAndView showNewSemesterSummaryForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-summary-new");
        mav.addObject("semesterSummary", new SemesterSummary());
        return mav;
    }

    @PostMapping("/new")
    public String saveSemesterSummary(@ModelAttribute("semesterSummary") SemesterSummary semesterSummary, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterSummaryService.saveSemesterSummary(semesterSummary);
        return "redirect:/admin/semester-summaries";
    }
}
