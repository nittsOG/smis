package com.manage.admin.controller;

import com.manage.admin.service.Admin_SemesterService;
import com.manage.home.entities.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/semesters")
public class AdminSemesterController {

    private final Admin_SemesterService adminSemesterService;

    @Autowired
    public AdminSemesterController(@Qualifier("adminSemesterServiceImpl") Admin_SemesterService adminSemesterService) {
        this.adminSemesterService = adminSemesterService;
    }

    @GetMapping
    public ModelAndView listSemesters(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Semester> semesters = adminSemesterService.getAllSemesters();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semesters");
        mav.addObject("semesters", semesters);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showSemesterDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Semester semester = adminSemesterService.getSemesterById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-details");
        mav.addObject("semester", semester);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditSemesterForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Semester semester = adminSemesterService.getSemesterById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-edit");
        mav.addObject("semester", semester);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateSemester(@PathVariable Long id, @ModelAttribute("semester") Semester semester, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterService.updateSemester(semester);
        return "redirect:/admin/semesters/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteSemester(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterService.deleteSemester(id);
        return "redirect:/admin/semesters";
    }

    @GetMapping("/new")
    public ModelAndView showNewSemesterForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-new");
        mav.addObject("semester", new Semester());
        return mav;
    }

    @PostMapping("/new")
    public String saveSemester(@ModelAttribute("semester") Semester semester, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterService.saveSemester(semester);
        return "redirect:/admin/semesters";
    }
}
