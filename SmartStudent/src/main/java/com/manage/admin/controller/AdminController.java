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

//    @PostMapping("/login")
//    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) {
//        if (adminService.validateAdmin(username, password)) {
//            session.setAttribute("adminUsername", username);
//            return new ModelAndView("redirect:/admin/dashboard");
//        } else {
//            ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-login");
//            mav.addObject("error", "Invalid username or password");
//            return mav;
//        }
//    }
    
    @PostMapping("/login")
    public ModelAndView login(@RequestParam Long id, @RequestParam String password, HttpSession session) {
        if (adminService.validateAdmin(id, password)) {
            session.setAttribute("adminId", id);
            return new ModelAndView("redirect:/admin/dashboard");
        } else {
            ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-login");
            mav.addObject("error", "Invalid ID or password");
            return mav;
        }
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-dashboard");
//        mav.addObject("adminUsername", adminUsername);
//        Admin admin = adminService.getAdminByUsername(adminUsername);
        Admin admin=adminService.getAdminById(adminId);
        mav.addObject("admin", admin);
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
