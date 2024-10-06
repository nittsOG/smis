package com.manage.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.faculty.service.FacultyService;
import com.manage.student.service.StudentService;

@Controller
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private FacultyService facultyService;

	@GetMapping
	public String showLoginForm() {
		return "JSP/forgot-password";
	}

	@PostMapping
	public ModelAndView changePassword(@RequestParam("role") String role, @RequestParam("id") Long id,
			@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
		boolean passwordChanged = false;

		if ("student".equals(role)) {
			if (studentService.validateStudent(id, oldPassword)) {
				studentService.changePassword(id, newPassword);
				passwordChanged = true;
			}
		} else if ("faculty".equals(role)) {
			if (facultyService.validateFaculty(id, oldPassword)) {
				facultyService.changePassword(id, newPassword);
				passwordChanged = true;
			}
		}

		ModelAndView mav = new ModelAndView("JSP/forgot-password");
		if (passwordChanged) {
			mav.addObject("message", "Password changed successfully");
		} else {
			mav.addObject("error", "Old password is incorrect");
		}

		return mav;
	}
}
