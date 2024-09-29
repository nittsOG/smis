package com.manage.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.admin.service.Admin_DepartmentService;
import com.manage.admin.service.Admin_ManagerAddressService;
import com.manage.admin.service.Admin_ManagerService;
import com.manage.home.entities.Department;
import com.manage.manager.entities.Manager;
import com.manage.manager.entities.ManagerAddress;

@Controller
@RequestMapping("/admin")
public class AdminManagerController {

	private final Admin_ManagerService adminManagerService;
	private final Admin_ManagerAddressService adminManagerAddressService;
	private final Admin_DepartmentService adminDepartmentService;

	@Autowired
	public AdminManagerController(@Qualifier("adminManagerServiceImpl") Admin_ManagerService adminManagerService,
			@Qualifier("adminManagerAddressServiceImpl") Admin_ManagerAddressService adminManagerAddressService,
			@Qualifier("adminDepartmentServiceImpl") Admin_DepartmentService adminDepartmentService) {
		this.adminManagerService = adminManagerService;
		this.adminManagerAddressService = adminManagerAddressService;
		this.adminDepartmentService = adminDepartmentService;
	}

	@GetMapping("/managers")
	public ModelAndView listManagers(@RequestParam(value = "managerId", required = false) Long managerId,
			@RequestParam(value = "departmentId", required = false) Long departmentId, HttpSession session) {

		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		ModelAndView modelAndView = new ModelAndView("JSP/ADMIN/admin-managers");

		List<Manager> managers;
		if (departmentId != null) {
			managers = adminManagerService.getManagersByDepartment(departmentId);
		} else {
			managers = adminManagerService.getAllManagers(); // Implement this method to fetch all managers
		}

		modelAndView.addObject("managers", managers);
		// Assuming you have a way to get departments as well
		modelAndView.addObject("departments", adminDepartmentService.getAllDepartments());

		return modelAndView;
	}

	@GetMapping("/managers/{managerId}")
	public ModelAndView showManagerDetails(@PathVariable Long managerId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Manager manager = adminManagerService.getManagerById(managerId);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-manager-details");
		mav.addObject("manager", manager);
		return mav;
	}

	@GetMapping("/managers/{managerId}/edit")
	public ModelAndView showEditManagerForm(@PathVariable Long managerId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Manager manager = adminManagerService.getManagerById(managerId);
		List<Department> departments = adminDepartmentService.getAllDepartments();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-manager-edit");
		mav.addObject("manager", manager);
		mav.addObject("departments", departments);
		return mav;
	}

	@PostMapping("/managers/{managerId}/edit")
	public String updateManager(@PathVariable Long managerId, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "email") String email,
			@RequestParam(value = "street") String street, @RequestParam(value = "city") String city,
			@RequestParam(value = "state") String state, @RequestParam(value = "country") String country,
			@RequestParam(value = "zipCode") String zipCode,
			@RequestParam(value = "department.departmentId") long departmentId, HttpSession session) {

		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		try {
			Manager manager = adminManagerService.getManagerById(managerId);
			manager.setUsername(username);
			manager.setPassword(password);
			manager.setEmail(email);

			Department department = adminDepartmentService.getDepartmentById(departmentId);
			manager.setDepartment(department);

			if (manager.getAddress() == null) {
				ManagerAddress newAddress = new ManagerAddress();
				newAddress.setManager(manager);
				newAddress.setStreet(street);
				newAddress.setCity(city);
				newAddress.setState(state);
				newAddress.setCountry(country);
				newAddress.setZipCode(zipCode);
				adminManagerAddressService.saveManagerAddress(newAddress);
				manager.setAddress(newAddress);
			} else {
				manager.getAddress().setStreet(street);
				manager.getAddress().setCity(city);
				manager.getAddress().setState(state);
				manager.getAddress().setCountry(country);
				manager.getAddress().setZipCode(zipCode);
			}

			adminManagerService.updateManager(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/managers/" + managerId;
	}

	@GetMapping("/managers/add")
	public ModelAndView addManager(HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		try {
			Manager manager = new Manager();
			manager.setUsername("default");
			manager.setEmail("default");
			manager.setPassword("default");
			adminManagerService.saveManager(manager);

			ManagerAddress address = new ManagerAddress();
			address.setCity("default");
			address.setCountry("default");
			address.setState("default");
			address.setStreet("default");
			address.setZipCode("default");
			address.setManager(manager);
			adminManagerAddressService.saveManagerAddress(address);
			manager.setAddress(address);
			adminManagerService.updateManager(manager);

			return new ModelAndView("redirect:/admin/managers");
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("redirect:/admin/managers");
			mav.addObject("error", "Manager with default data already exists");
			return mav;
		}
	}

	@PostMapping("/managers/delete/{managerId}")
	public String deleteManager(@PathVariable Long managerId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		try {
			adminManagerService.deleteManager(managerId);
			adminManagerAddressService.deleteManagerAddressByManagerId(managerId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/managers";
	}
}
