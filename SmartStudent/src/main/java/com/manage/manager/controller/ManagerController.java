package com.manage.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.manager.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "JSP/MANAGER/manager-login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (managerService.validateManager(username, password)) {
            session.setAttribute("managerUsername", username);
            return new ModelAndView("redirect:/manager/dashboard");
        } else {
            ModelAndView mav = new ModelAndView("manager-login");
            mav.addObject("error", "Invalid username or password");
            return mav;
        }
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        String managerUsername = (String) session.getAttribute("managerUsername");
        if (managerUsername == null) {
            return new ModelAndView("redirect:/manager/login");
        }
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-dashboard");
        mav.addObject("managerUsername", managerUsername);
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/manager/login";
    }
}
