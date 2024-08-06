package com.manage.admin.controller;

import com.manage.admin.service.Admin_ManagerService;
import com.manage.manager.entities.Manager;
import com.manage.manager.entities.ManagerAddress;
import com.manage.admin.service.Admin_DepartmentService;
import com.manage.home.entities.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/managers")
public class AdminManagerController {

    private final Admin_ManagerService adminManagerService;
    private final Admin_DepartmentService adminDepartmentService;

    @Autowired
    public AdminManagerController(
            @Qualifier("adminManagerServiceImpl") Admin_ManagerService adminManagerService,
            @Qualifier("adminDepartmentServiceImpl") Admin_DepartmentService adminDepartmentService) {
        this.adminManagerService = adminManagerService;
        this.adminDepartmentService = adminDepartmentService;
    }

    @GetMapping
    public ModelAndView listManagers(
            @RequestParam(value = "search", required = false) Long search,
            @RequestParam(value = "department", required = false) String department,
            HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Manager> managers = adminManagerService.getAllManagers();

        // Apply search by ID
        if (search != null) {
            managers = managers.stream()
                    .filter(manager -> manager.getManagerId().equals(search))
                    .collect(Collectors.toList());
        }

        // Apply department filter
        if (department != null && !department.isEmpty()) {
            managers = managers.stream()
                    .filter(manager -> manager.getDepartment() != null &&
                            manager.getDepartment().getName().equals(department))
                    .collect(Collectors.toList());
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-managers");
        mav.addObject("managers", managers);

        // Pass the unique departments for the dropdown filter
        Set<String> departments = adminDepartmentService.getAllDepartments().stream()
                .map(Department::getName)
                .collect(Collectors.toSet());
        mav.addObject("departments", departments);

        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showManagerDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Manager manager = adminManagerService.getManagerById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-manager-details");
        mav.addObject("manager", manager);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditManagerForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Manager manager = adminManagerService.getManagerById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-manager-edit");
        mav.addObject("manager", manager);

        List<Department> departments = adminDepartmentService.getAllDepartments();
        mav.addObject("departments", departments);

        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateManager(
            @PathVariable Long id,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "address.street") String street,
            @RequestParam(value = "address.city") String city,
            @RequestParam(value = "address.state") String state,
            @RequestParam(value = "address.country") String country,
            @RequestParam(value = "address.zipCode") String zipcode,
            @RequestParam(value = "department.departmentId") long departmentId,
            HttpSession session) {

        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        Manager manager = adminManagerService.getManagerById(id);
        ManagerAddress address = manager.getAddress();

        // Update Manager entity
        if (!username.equals(manager.getUsername())) {
            manager.setUsername(username);
        }
        if (!password.equals(manager.getPassword())) {
            manager.setPassword(password);
        }
        if (!email.equals(manager.getEmail())) {
            manager.setEmail(email);
        }

        // Update ManagerAddress entity
        if (!street.equals(address.getStreet())) {
            address.setStreet(street);
        }
        if (!city.equals(address.getCity())) {
            address.setCity(city);
        }
        if (!state.equals(address.getState())) {
            address.setState(state);
        }
        if (!country.equals(address.getCountry())) {
            address.setCountry(country);
        }
        if (!zipcode.equals(address.getZipCode())) {
            address.setZipCode(zipcode);
        }

        // Update Department
        Department department = adminDepartmentService.getDepartmentById(departmentId);
        manager.setDepartment(department);

        // Save the updated manager
        adminManagerService.updateManager(manager);

        return "redirect:/admin/managers/" + id;
    }

    @GetMapping("/{id}/delete")
    public String deleteManager(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminManagerService.deleteManager(id);
        return "redirect:/admin/managers";
    }

    @GetMapping("/new")
    public ModelAndView showNewManagerForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-manager-new");
        mav.addObject("manager", new Manager());

        List<Department> departments = adminDepartmentService.getAllDepartments();
        mav.addObject("departments", departments);

        return mav;
    }

    @PostMapping("/new")
    public String saveManager(@ModelAttribute("manager") Manager manager, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminManagerService.saveManager(manager);
        return "redirect:/admin/managers";
    }
}
