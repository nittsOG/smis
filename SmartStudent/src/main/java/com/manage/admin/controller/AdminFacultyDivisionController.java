package com.manage.admin.controller;

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

import com.manage.admin.service.Admin_DivisionService;
import com.manage.admin.service.Admin_FacultyDivisionService;
import com.manage.faculty.entities.FacultyDivision;
import com.manage.home.entities.Division;

@Controller
@RequestMapping("/admin/facultyDivisions")
public class AdminFacultyDivisionController {

    private final Admin_FacultyDivisionService adminFacultyDivisionService;
    private final Admin_DivisionService admin_DivisionService;

    @Autowired
    public AdminFacultyDivisionController(@Qualifier("adminFacultyDivisionServiceImpl") Admin_FacultyDivisionService adminFacultyDivisionService,
    		@Qualifier("adminDivisionServiceImpl") Admin_DivisionService admin_DivisionService) {
        this.adminFacultyDivisionService = adminFacultyDivisionService;
        this.admin_DivisionService = admin_DivisionService;
    }

    @GetMapping
    public ModelAndView listFacultyDivisions(@RequestParam(value = "facultyId", required = false) Long facultyId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<FacultyDivision> facultyDivisions;
        
        if (facultyId != null) {
            facultyDivisions = adminFacultyDivisionService.getFacultyDivisionsByFacultyId(facultyId);
        } else {
            facultyDivisions = adminFacultyDivisionService.getAllFacultyDivisions();
        }

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
        List<Division> divisions = admin_DivisionService.getAllDivisions();  // Fetch all divisions

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultyDivision-edit");
        mav.addObject("facultyDivision", facultyDivision);
        mav.addObject("divisions", divisions); // Pass list of divisions to the view
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

        List<Division> divisions = admin_DivisionService.getAllDivisions();  // Fetch all divisions
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultyDivision-new");
        mav.addObject("facultyDivision", new FacultyDivision());
        mav.addObject("divisions", divisions); // Pass list of divisions to the view
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
