package com.manage.admin.controller;

import com.manage.admin.service.Admin_FacultyDivisionService;
import com.manage.faculty.entities.FacultyDivision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/facultyDivisions")
public class AdminFacultyDivisionController {

    private final Admin_FacultyDivisionService adminFacultyDivisionService;

    @Autowired
    public AdminFacultyDivisionController(@Qualifier("adminFacultyDivisionServiceImpl") Admin_FacultyDivisionService adminFacultyDivisionService) {
        this.adminFacultyDivisionService = adminFacultyDivisionService;
    }

    @GetMapping
    public ModelAndView listFacultyDivisions(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<FacultyDivision> facultyDivisions = adminFacultyDivisionService.getAllFacultyDivisions();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultyDivisions");
        mav.addObject("facultyDivisions", facultyDivisions);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showFacultyDivisionDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        FacultyDivision facultyDivision = adminFacultyDivisionService.getFacultyDivisionById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultyDivision-details");
        mav.addObject("facultyDivision", facultyDivision);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditFacultyDivisionForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        FacultyDivision facultyDivision = adminFacultyDivisionService.getFacultyDivisionById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultyDivision-edit");
        mav.addObject("facultyDivision", facultyDivision);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateFacultyDivision(@PathVariable Long id, @ModelAttribute("facultyDivision") FacultyDivision facultyDivision, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminFacultyDivisionService.updateFacultyDivision(facultyDivision);
        return "redirect:/admin/facultyDivisions/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteFacultyDivision(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminFacultyDivisionService.deleteFacultyDivision(id);
        return "redirect:/admin/facultyDivisions";
    }

    @GetMapping("/new")
    public ModelAndView showNewFacultyDivisionForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultyDivision-new");
        mav.addObject("facultyDivision", new FacultyDivision());
        return mav;
    }

    @PostMapping("/new")
    public String saveFacultyDivision(@ModelAttribute("facultyDivision") FacultyDivision facultyDivision, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminFacultyDivisionService.saveFacultyDivision(facultyDivision);
        return "redirect:/admin/facultyDivisions";
    }
}
