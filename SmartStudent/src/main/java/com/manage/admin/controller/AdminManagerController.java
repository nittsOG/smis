package com.manage.admin.controller;

import com.manage.admin.service.Admin_ManagerService;
import com.manage.manager.entities.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/manager")
public class AdminManagerController {

    private final Admin_ManagerService adminManagerService;

    @Autowired
    public AdminManagerController(@Qualifier("adminManagerServiceImpl") Admin_ManagerService adminManagerService) {
        this.adminManagerService = adminManagerService;
    }

    @GetMapping("/list")
    public ModelAndView listManagers(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        List<Manager> managers = adminManagerService.getAllManagers();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/manager-list");
        mav.addObject("managers", managers);
        return mav;
    }

    @GetMapping("/showFormForAdd")
    public ModelAndView showFormForAdd(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        Manager manager = new Manager();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/manager-form");
        mav.addObject("manager", manager);
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView saveManager(@ModelAttribute("manager") Manager manager, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        adminManagerService.saveManager(manager);
        return new ModelAndView("redirect:/admin/manager/list");
    }

    @GetMapping("/showFormForUpdate")
    public ModelAndView showFormForUpdate(@RequestParam("managerId") Long managerId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        Manager manager = adminManagerService.getManagerById(managerId);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/manager-form");
        mav.addObject("manager", manager);
        return mav;
    }

    @GetMapping("/delete")
    public ModelAndView deleteManager(@RequestParam("managerId") Long managerId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }
        Manager manager = adminManagerService.getManagerById(managerId);
        adminManagerService.deleteManager(manager);
        return new ModelAndView("redirect:/admin/manager/list");
    }
}
