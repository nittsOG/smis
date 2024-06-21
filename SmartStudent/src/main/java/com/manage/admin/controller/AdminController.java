package com.manage.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.manage.admin.service.AdminService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "JSP/ADMIN/admin-login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (adminService.validateAdmin(username, password)) {
            session.setAttribute("adminUsername", username);
            return new ModelAndView("redirect:/admin/dashboard");
        } else {
            ModelAndView mav = new ModelAndView("admin-login");
            mav.addObject("error", "Invalid username or password");
            return mav;
        }
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        String adminUsername = (String) session.getAttribute("adminUsername");
        if (adminUsername == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-dashboard");
        mav.addObject("adminUsername", adminUsername);
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}

