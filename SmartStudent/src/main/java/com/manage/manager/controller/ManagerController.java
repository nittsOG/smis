package com.manage.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.manager.entities.Manager;
import com.manage.manager.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    
    private ManagerService managerService;
    
    @Autowired
    public ManagerController(ManagerService managerService) {
		super();
		this.managerService = managerService;
	}

	@GetMapping("/login")
    public String showLoginForm() {
        return "JSP/MANAGER/manager-login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam Long id, @RequestParam String password, HttpSession session) {
        if (managerService.validateManager(id, password)) {
            session.setAttribute("managerId", id);
            return new ModelAndView("redirect:/manager/dashboard");
        } else {
            ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-login");
            mav.addObject("error", "Invalid id or password");
            return mav;
        }
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        Long id = (Long) session.getAttribute("managerId");
        if (id == null) {
            return new ModelAndView("redirect:/manager/login");
        }
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-dashboard");
//        mav.addObject("managerUsername", managerUsername);
        Manager manager = managerService.getManagerById(id);
        mav.addObject("manager", manager);
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/manager/login";
    }
}
