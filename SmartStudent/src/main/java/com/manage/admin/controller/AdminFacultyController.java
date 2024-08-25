package com.manage.admin.controller;

import com.manage.admin.service.Admin_FacultyService;
import com.manage.faculty.entities.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/faculty")
public class AdminFacultyController {

    private final Admin_FacultyService adminFacultyService;

    @Autowired
    public AdminFacultyController(@Qualifier("adminFacultyServiceImpl") Admin_FacultyService adminFacultyService) {
        this.adminFacultyService = adminFacultyService;
    }

    @GetMapping("/list")
    public ModelAndView listFaculties(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        List<Faculty> faculties = adminFacultyService.getAllFaculties();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/faculty-list");
        mav.addObject("faculties", faculties);
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView showFormForAdd(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        Faculty faculty = new Faculty();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/faculty-form");
        mav.addObject("faculty", faculty);
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView saveFaculty(@ModelAttribute("faculty") Faculty faculty, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        adminFacultyService.saveFaculty(faculty);
        return new ModelAndView("redirect:/admin/faculty/list");
    }

    @GetMapping("/edit")
    public ModelAndView showFormForUpdate(@RequestParam("facultyId") Long facultyId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        Faculty faculty = adminFacultyService.getFacultyById(facultyId);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/faculty-form");
        mav.addObject("faculty", faculty);
        return mav;
    }

    @GetMapping("/delete")
    public ModelAndView deleteFaculty(@RequestParam("facultyId") Long facultyId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        Faculty faculty = adminFacultyService.getFacultyById(facultyId);
        adminFacultyService.deleteFaculty(faculty);
        return new ModelAndView("redirect:/admin/faculty/list");
    }
}
