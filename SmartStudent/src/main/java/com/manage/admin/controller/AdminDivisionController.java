package com.manage.admin.controller;

import com.manage.admin.service.Admin_DivisionService;
import com.manage.home.entities.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/divisions")
public class AdminDivisionController {

    private final Admin_DivisionService adminDivisionService;

    @Autowired
    public AdminDivisionController(@Qualifier("adminDivisionServiceImpl") Admin_DivisionService adminDivisionService) {
        this.adminDivisionService = adminDivisionService;
    }

    @GetMapping
    public ModelAndView listDivisions(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Division> divisions = adminDivisionService.getAllDivisions();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-divisions");
        mav.addObject("divisions", divisions);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showDivisionDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Division division = adminDivisionService.getDivisionById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-division-details");
        mav.addObject("division", division);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditDivisionForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Division division = adminDivisionService.getDivisionById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-division-edit");
        mav.addObject("division", division);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateDivision(@PathVariable Long id, @ModelAttribute("division") Division division, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminDivisionService.updateDivision(division);
        return "redirect:/admin/divisions/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteDivision(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminDivisionService.deletebyId(id);
        return "redirect:/admin/divisions";
    }

    @GetMapping("/new")
    public ModelAndView showNewDivisionForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-division-new");
        mav.addObject("division", new Division());
        return mav;
    }

    @PostMapping("/new")
    public String saveDivision(@ModelAttribute("division") Division division, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminDivisionService.saveDivision(division);
        return "redirect:/admin/divisions";
    }
}
