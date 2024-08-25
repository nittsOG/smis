package com.manage.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.manage.admin.entities.Admin;
import com.manage.admin.service.AdminService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(@Qualifier("adminServiceImpl") AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "JSP/ADMIN/admin-login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam Long id, @RequestParam String password, HttpSession session) {
        try {
            if (adminService.validateAdmin(id, password)) {
                session.setAttribute("adminId", id);
                return new ModelAndView("redirect:/admin/dashboard");
            } else {
                ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-login");
                mav.addObject("error", "Invalid ID or password");
                return mav;
            }
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-login");
            mav.addObject("error", "An error occurred while processing your request. Please try again later.");
            return mav;
        }
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        try {
            Long adminId = (Long) session.getAttribute("adminId");
            if (adminId == null) {
                return new ModelAndView("redirect:/admin/login");
            }
            ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-dashboard");
            Admin admin = adminService.getAdminById(adminId);
            mav.addObject("admin", admin);
            return mav;
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView("redirect:/admin/login");
            mav.addObject("error", "An error occurred while loading the dashboard. Please try again later.");
            return mav;
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
