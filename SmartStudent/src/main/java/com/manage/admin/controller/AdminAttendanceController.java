package com.manage.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.manage.admin.service.Admin_AttendanceService;
import com.manage.home.entities.Attendance;
import com.manage.home.entities.AttendanceStatus;

@Controller
@RequestMapping("/admin/attendances")
public class AdminAttendanceController {

	private final Admin_AttendanceService adminAttendanceService;

	@Autowired
	public AdminAttendanceController(
			@Qualifier("adminAttendanceServiceImpl") Admin_AttendanceService adminAttendanceService) {
		this.adminAttendanceService = adminAttendanceService;
	}

	// List attendances with filters
	@GetMapping
	public ModelAndView listAttendances(@RequestParam(required = false) Long studentId,
			@RequestParam(required = false) Long divisionId, @RequestParam(required = false) Long subjectId,
			@RequestParam(required = false) String date, // Accept date as a string
			HttpSession session) {

		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Date parsedDate = null; // Initialize date variable

		// Convert the date string to a Date object
		if (date != null && !date.isEmpty()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				parsedDate = dateFormat.parse(date); // Parse the date string
			} catch (ParseException e) {
				// Handle date parsing error
				ModelAndView modelAndView = new ModelAndView("/JSP/ADMIN/admin-attendances");
				modelAndView.addObject("error", "Invalid date format. Please use 'yyyy-MM-dd'.");
				return modelAndView;
			}
		}

		List<Attendance> attendances = adminAttendanceService.getFilteredAttendances(studentId, divisionId, subjectId,
				parsedDate); // Pass parsedDate to service

		ModelAndView modelAndView = new ModelAndView("/JSP/ADMIN/admin-attendances");
		modelAndView.addObject("attendances", attendances);

		return modelAndView;
	}

	// Get attendance by ID
	@GetMapping("/{id}")
	public ModelAndView getAttendanceById(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Attendance attendance = adminAttendanceService.getAttendanceById(id);
		ModelAndView modelAndView = new ModelAndView("/JSP/ADMIN/admin-attendance-details"); // View for attendance
																								// details
		modelAndView.addObject("attendance", attendance);

		return modelAndView;
	}

	// Show Edit Attendance Form
	@GetMapping("/{id}/edit")
	public ModelAndView showEditAttendanceForm(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Attendance attendance = adminAttendanceService.getAttendanceById(id);
		ModelAndView modelAndView = new ModelAndView("/JSP/ADMIN/admin-attendance-edit"); // View for editing attendance
		modelAndView.addObject("attendance", attendance);

		return modelAndView;
	}

	// Edit attendance
	@PostMapping("/{id}/edit")
	public String updateAttendance(@PathVariable Long id, @RequestParam("status") AttendanceStatus status,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		Attendance attendance = adminAttendanceService.getAttendanceById(id);
		attendance.setStatus(status);
		adminAttendanceService.updateAttendance(attendance);

		return "redirect:/admin/attendances/" + id;
	}

	// Delete attendance
	@GetMapping("/{id}/delete")
	public String deleteAttendance(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminAttendanceService.deleteAttendance(id);
		return "redirect:/admin/attendances";
	}
}
