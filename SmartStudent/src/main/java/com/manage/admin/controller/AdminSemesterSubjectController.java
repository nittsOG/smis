package com.manage.admin.controller;

import com.manage.admin.service.Admin_SemesterSubjectService;
import com.manage.home.entities.SemesterSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/semester-subjects")
public class AdminSemesterSubjectController {

    private final Admin_SemesterSubjectService adminSemesterSubjectService;

    @Autowired
    public AdminSemesterSubjectController(@Qualifier("adminSemesterSubjectServiceImpl") Admin_SemesterSubjectService adminSemesterSubjectService) {
        this.adminSemesterSubjectService = adminSemesterSubjectService;
    }

    @GetMapping
    public ModelAndView listSemesterSubjects(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<SemesterSubject> semesterSubjects = adminSemesterSubjectService.getAllSemesterSubjects();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-subjects");
        mav.addObject("semesterSubjects", semesterSubjects);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showSemesterSubjectDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        SemesterSubject semesterSubject = adminSemesterSubjectService.getSemesterSubjectById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-subject-details");
        mav.addObject("semesterSubject", semesterSubject);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditSemesterSubjectForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        SemesterSubject semesterSubject = adminSemesterSubjectService.getSemesterSubjectById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-subject-edit");
        mav.addObject("semesterSubject", semesterSubject);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateSemesterSubject(@PathVariable Long id, @ModelAttribute("semesterSubject") SemesterSubject semesterSubject, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterSubjectService.updateSemesterSubject(semesterSubject);
        return "redirect:/admin/semester-subjects/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteSemesterSubject(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterSubjectService.deleteSemesterSubject(id);
        return "redirect:/admin/semester-subjects";
    }

    @GetMapping("/new")
    public ModelAndView showNewSemesterSubjectForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-subject-new");
        mav.addObject("semesterSubject", new SemesterSubject());
        return mav;
    }

    @PostMapping("/new")
    public String saveSemesterSubject(@ModelAttribute("semesterSubject") SemesterSubject semesterSubject, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterSubjectService.saveSemesterSubject(semesterSubject);
        return "redirect:/admin/semester-subjects";
    }
}
