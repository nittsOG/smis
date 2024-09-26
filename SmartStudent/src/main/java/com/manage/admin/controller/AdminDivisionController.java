package com.manage.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.admin.service.Admin_DepartmentService;
import com.manage.admin.service.Admin_DivisionService;
import com.manage.home.entities.Department;
import com.manage.home.entities.Division;

@Controller
@RequestMapping("/admin/divisions")
public class AdminDivisionController {

	private final Admin_DivisionService adminDivisionService;
	private final Admin_DepartmentService adminDepartmentService;

	@Autowired
	public AdminDivisionController(@Qualifier("adminDivisionServiceImpl") Admin_DivisionService adminDivisionService,
			@Qualifier("adminDepartmentServiceImpl") Admin_DepartmentService adminDepartmentService) {
		this.adminDivisionService = adminDivisionService;
		this.adminDepartmentService = adminDepartmentService;
	}

	@GetMapping
	public ModelAndView listDivisions(@RequestParam(value = "department", required = false) Long departmentId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		// Fetch all divisions, filtered by department ID if provided
		List<Division> divisions;
		if (departmentId != null) {
			divisions = adminDivisionService.getDivisionsByDepartment(departmentId);
		} else {
			divisions = adminDivisionService.getAllDivisions();
		}

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-divisions");
		mav.addObject("divisions", divisions);

		// Fetch all available departments to populate the dropdown filter
		List<Department> departments = adminDepartmentService.getAllDepartments();
		mav.addObject("departments", departments);

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

	    // Add departments to the model to populate the dropdown
	    List<Department> departments = adminDepartmentService.getAllDepartments();
	    mav.addObject("departments", departments);
	    
	    return mav;
	}


	@PostMapping("/{id}/edit")
	public String updateDivision(@PathVariable Long id, @RequestParam("divisionId") Long divisionId, 
	                             @ModelAttribute("division") Division division, @RequestParam("departmentId") Long departmentId, 
	                             HttpSession session) {
	    Long adminId = (Long) session.getAttribute("adminId");
	    if (adminId == null) {
	        return "redirect:/admin/login";
	    }

	    // Fetch the existing Division entity from the database
	    Division existingDivision = adminDivisionService.getDivisionById(divisionId);
	    if (existingDivision == null) {
	        session.setAttribute("errorMessage", "Division not found");
	        return "redirect:/admin/divisions";
	    }

	    // Update the existing division's fields
	    existingDivision.setName(division.getName());
	    
	    // Fetch the selected department and set it to the division
	    Department department = adminDepartmentService.getDepartmentById(departmentId);
	    existingDivision.setDepartment(department);

	    // Save the updated division
	    adminDivisionService.updateDivision(existingDivision);

	    return "redirect:/admin/divisions/{id}";
	}



	@GetMapping("/{id}/delete")
	public String deleteDivision(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		try {
			adminDivisionService.deletebyId(id);
			session.setAttribute("successMessage", "Division deleted successfully.");
		} catch (DataIntegrityViolationException e) {
			session.setAttribute("errorMessage",
					"Cannot delete division :  ( id = " + id + " ) because it has associated records.");
		} catch (Exception e) {
			session.setAttribute("errorMessage", "An error occurred while trying to delete the division.");
		}
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
	    
	    // Add departments to the model to populate the dropdown
	    List<Department> departments = adminDepartmentService.getAllDepartments();
	    mav.addObject("departments", departments);
	    
	    return mav;
	}


	@PostMapping("/new")
	public String saveDivision(@ModelAttribute("division") Division division, @RequestParam("departmentId") Long departmentId, HttpSession session) {
	    Long adminId = (Long) session.getAttribute("adminId");
	    if (adminId == null) {
	        return "redirect:/admin/login";
	    }

	    Department department = adminDepartmentService.getDepartmentById(departmentId);
	    division.setDepartment(department);

	    adminDivisionService.saveDivision(division);
	    return "redirect:/admin/divisions";
	}

}
