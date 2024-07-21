package com.manage.admin.controller;

import com.manage.admin.service.Admin_DepartmentService;
import com.manage.home.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/departments")
public class AdminDepartmentController {

    private final Admin_DepartmentService adminDepartmentService;

    @Autowired
    public AdminDepartmentController(@Qualifier("adminDepartmentServiceImpl") Admin_DepartmentService adminDepartmentService) {
        this.adminDepartmentService = adminDepartmentService;
    }

    @GetMapping
    public ModelAndView listDepartments(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Department> departments = adminDepartmentService.getAllDepartments();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-departments");
        mav.addObject("departments", departments);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showDepartmentDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Department department = adminDepartmentService.getDepartmentById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-department-details");
        mav.addObject("department", department);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditDepartmentForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Department department = adminDepartmentService.getDepartmentById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-department-edit");
        mav.addObject("department", department);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateDepartment(@PathVariable Long id, @ModelAttribute("department") Department department, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminDepartmentService.updateDepartment(department);
        return "redirect:/admin/departments/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteDepartment(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminDepartmentService.deleteDepartment(id);
        return "redirect:/admin/departments";
    }

    @GetMapping("/new")
    public ModelAndView showNewDepartmentForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-department-new");
        mav.addObject("department", new Department());
        return mav;
    }

    @PostMapping("/new")
    public String saveDepartment(@ModelAttribute("department") Department department, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminDepartmentService.saveDepartment(department);
        return "redirect:/admin/departments";
    }
}
