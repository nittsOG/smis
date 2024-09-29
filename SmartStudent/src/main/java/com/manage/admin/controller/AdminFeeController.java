package com.manage.admin.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.manage.admin.service.Admin_FeeService;
import com.manage.admin.service.Admin_StudentSemesterService;
import com.manage.student.entities.Fee;

@Controller
@RequestMapping("/admin/fees")
public class AdminFeeController {

	private final Admin_FeeService adminFeeService;
	private final Admin_StudentSemesterService admin_StudentSemesterService;

	@Autowired
	public AdminFeeController(@Qualifier("adminFeeServiceImpl") Admin_FeeService adminFeeService,
			@Qualifier("adminStudentSemesterServiceImpl") Admin_StudentSemesterService admin_StudentSemesterService) {
		this.adminFeeService = adminFeeService;
		this.admin_StudentSemesterService = admin_StudentSemesterService;
	}

	// List fees with optional filtering by studentId
	@GetMapping
	public ModelAndView listFees(@RequestParam(value = "studentId", required = false) Long studentId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Fee> fees;
		if (studentId != null) {
			fees = adminFeeService.getFeesByStudentId(studentId);
		} else {
			fees = adminFeeService.getAllFees();
		}

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-fees");
		mav.addObject("fees", fees);
		return mav;
	}

	// Show fee details
	@GetMapping("/{id}")
	public ModelAndView showFeeDetails(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Fee fee = adminFeeService.getFeeById(id);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-fee-details");
		mav.addObject("fee", fee);
		return mav;
	}

	// Show form to edit a fee
	@GetMapping("/{id}/edit")
	public ModelAndView showEditFeeForm(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Fee fee = adminFeeService.getFeeById(id);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-fee-edit");
		mav.addObject("fee", fee);
		return mav;
	}

	// Update fee using @RequestParam instead of @ModelAttribute
	@PostMapping("/{id}/edit")
	public String updateFee(@PathVariable Long id, @RequestParam("totalAmount") BigDecimal totalAmount,
			@RequestParam("paidAmount") BigDecimal paidAmount, @RequestParam("dueDate") String dueDate,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		Fee fee = adminFeeService.getFeeById(id);
		fee.setTotalAmount(totalAmount);
		fee.setPaidAmount(paidAmount);

		// Parsing date from string
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fee.setDueDate(dateFormat.parse(dueDate));
		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/admin/fees/" + id + "/edit?error=Invalid date format";
		}

		adminFeeService.updateFee(fee);
		return "redirect:/admin/fees/" + id;
	}

	// Delete fee
	@GetMapping("/{id}/delete")
	public String deleteFee(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminFeeService.deleteFee(id);
		return "redirect:/admin/fees";
	}

//	// Show form to create a new fee
//	@GetMapping("/new")
//	public ModelAndView showNewFeeForm(HttpSession session) {
//		Long adminId = (Long) session.getAttribute("adminId");
//		if (adminId == null) {
//			return new ModelAndView("redirect:/admin/login");
//		}
//
//		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-fee-new");
//		mav.addObject("fee", new Fee());
//		return mav;
//	}
//
//	// Save new fee using @RequestParam instead of @ModelAttribute
//	@PostMapping("/new")
//	public String saveFee(@RequestParam("totalAmount") BigDecimal totalAmount,
//			@RequestParam("paidAmount") BigDecimal paidAmount, @RequestParam("dueDate") String dueDate,
//			@RequestParam("studentSemesterId") Long studentSemesterId, HttpSession session) {
//		Long adminId = (Long) session.getAttribute("adminId");
//		if (adminId == null) {
//			return "redirect:/admin/login";
//		}
//
//		Fee fee = new Fee();
//		fee.setTotalAmount(totalAmount);
//		fee.setPaidAmount(paidAmount);
//		fee.setStudentSemester(admin_StudentSemesterService.getStudentSemesterById(studentSemesterId));
//
//		// Parsing date from string
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			fee.setDueDate(dateFormat.parse(dueDate));
//		} catch (ParseException e) {
//			e.printStackTrace();
//			return "redirect:/admin/fees/new?error=Invalid date format";
//		}
//
//		adminFeeService.saveFee(fee);
//		return "redirect:/admin/fees";
//	}
}
