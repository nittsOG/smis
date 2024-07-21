package com.manage.admin.controller;

import com.manage.admin.service.Admin_FacultySubjectService;
import com.manage.faculty.entities.FacultySubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/facultySubjects")
public class AdminFacultySubjectController {

    private final Admin_FacultySubjectService adminFacultySubjectService;

    @Autowired
    public AdminFacultySubjectController(@Qualifier("adminFacultySubjectServiceImpl") Admin_FacultySubjectService adminFacultySubjectService) {
        this.adminFacultySubjectService = adminFacultySubjectService;
    }

    @GetMapping
    public ModelAndView listFacultySubjects(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<FacultySubject> facultySubjects = adminFacultySubjectService.getAllFacultySubjects();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultySubjects");
        mav.addObject("facultySubjects", facultySubjects);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showFacultySubjectDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        FacultySubject facultySubject = adminFacultySubjectService.getFacultySubjectById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultySubject-details");
        mav.addObject("facultySubject", facultySubject);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditFacultySubjectForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        FacultySubject facultySubject = adminFacultySubjectService.getFacultySubjectById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultySubject-edit");
        mav.addObject("facultySubject", facultySubject);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateFacultySubject(@PathVariable Long id, @ModelAttribute("facultySubject") FacultySubject facultySubject, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminFacultySubjectService.updateFacultySubject(facultySubject);
        return "redirect:/admin/facultySubjects/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteFacultySubject(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminFacultySubjectService.deleteFacultySubject(id);
        return "redirect:/admin/facultySubjects";
    }

    @GetMapping("/new")
    public ModelAndView showNewFacultySubjectForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultySubject-new");
        mav.addObject("facultySubject", new FacultySubject());
        return mav;
    }

    @PostMapping("/new")
    public String saveFacultySubject(@ModelAttribute("facultySubject") FacultySubject facultySubject, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminFacultySubjectService.saveFacultySubject(facultySubject);
        return "redirect:/admin/facultySubjects";
    }
}
