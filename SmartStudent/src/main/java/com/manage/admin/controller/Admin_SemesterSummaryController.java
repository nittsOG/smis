package com.manage.admin.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.admin.service.Admin_SemesterSummaryService;
import com.manage.student.entities.SemesterSummary;

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
    public ModelAndView showSemesterSummaryDetails(@PathVariable Long studentId, @PathVariable Integer semester, HttpSession session) {
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
    public ModelAndView showEditSemesterSummaryForm(@PathVariable Long studentId, @PathVariable Integer semester, HttpSession session) {
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
    public String deleteSemesterSummary(@PathVariable Long studentId, @PathVariable Integer semester, HttpSession session) {
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
    public String saveSemesterSummary(
            @RequestParam("studentId") Long studentId,
            @RequestParam("semester") Integer semester,
            @RequestParam("totalCredits") BigDecimal totalCredits,
            @RequestParam("totalCreditPoints") BigDecimal totalCreditPoints,
            @RequestParam("sgpa") BigDecimal sgpa,
            @RequestParam("cgpa") BigDecimal cgpa,
            HttpSession session) {
        
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        // Create a new SemesterSummary object manually
        SemesterSummary semesterSummary = new SemesterSummary();
        semesterSummary.setStudentId(studentId);
        semesterSummary.setSemester(semester);
        semesterSummary.setTotalCredits(totalCredits);
        semesterSummary.setTotalCreditPoints(totalCreditPoints);
        semesterSummary.setSgpa(sgpa);
        semesterSummary.setCgpa(cgpa);

        // Log to check if data is bound correctly
        System.out.println("SemesterSummary: " + semesterSummary.getStudentId());

        adminSemesterSummaryService.saveSemesterSummary(semesterSummary);
        return "redirect:/admin/semester-summaries";
    }


}
