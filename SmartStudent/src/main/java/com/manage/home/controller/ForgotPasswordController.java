package com.manage.home.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

	@Autowired
	private JavaMailSender mailSender;

	private Map<Long, String> otpStore = new HashMap<>();
	private Map<Long, LocalDateTime> otpExpiryStore = new HashMap<>();
	private static final long OTP_VALID_DURATION = 5; // OTP valid for 5 minutes

	@GetMapping
	public String showForgotPasswordForm() {
		return "JSP/forgot-password";
	}

	@PostMapping("/generate-otp")
	public ModelAndView generateOtp(@RequestParam("role") String role, @RequestParam("id") Long id,
			HttpSession session) {
		String email = "";
		boolean userExists = false;

		if ("student".equals(role)) {
			try {
				if (studentService.getStudentById(id) != null) {
					userExists = true;
				}
			} catch (Exception e) {
				// handle exception
			}
			if (userExists) {
				email = studentService.getStudentById(id).getEmail();
			}
		} else if ("faculty".equals(role)) {
			try {
				if (facultyService.getFacultyById(id) != null) {
					userExists = true;
				}
			} catch (Exception e) {
				// handle exception
			}
			if (userExists) {
				email = facultyService.getFacultyById(id).getEmail();
			}
		}

		ModelAndView mav = new ModelAndView("JSP/forgot-password");
		if (userExists) {
			// Generate OTP
			String otp = generateOtp();
			otpStore.put(id, otp);
			otpExpiryStore.put(id, LocalDateTime.now().plusMinutes(OTP_VALID_DURATION));

			// Send OTP to user's email
			sendOtpEmail(email, otp);

			mav.addObject("message", "OTP sent to your email.");
		} else {
			mav.addObject("error", "User not found.");
		}

		// Add role and id back to the model
		mav.addObject("selectedRole", role);
		mav.addObject("enteredId", id);

		return mav;
	}

	@PostMapping("/reset-password")
	public ModelAndView resetPassword(@RequestParam("role") String role, @RequestParam("id") Long id,
			@RequestParam("otp") String otp, @RequestParam("newPassword") String newPassword) {
		ModelAndView mav = new ModelAndView("JSP/forgot-password");

		boolean validOtp = validateOtp(id, otp);

		if (validOtp) {
			if ("student".equals(role)) {
				studentService.changePassword(id, newPassword);
			} else if ("faculty".equals(role)) {
				facultyService.changePassword(id, newPassword);
			}
			mav.addObject("message", "Password changed successfully.");
		} else {
			mav.addObject("error", "Invalid or expired OTP.");
		}

		return mav;
	}

	private String generateOtp() {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000); // 6-digit OTP
		return String.valueOf(otp);
	}

	private void sendOtpEmail(String email, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Your OTP for Password Reset");
		message.setText("Your OTP is: " + otp + ". It is valid for 5 minutes.");
		mailSender.send(message);
	}

	private boolean validateOtp(Long id, String otp) {
		if (!otpStore.containsKey(id)) {
			return false;
		}
		if (otpExpiryStore.get(id).isBefore(LocalDateTime.now())) {
			otpStore.remove(id);
			otpExpiryStore.remove(id);
			return false;
		}
		return otpStore.get(id).equals(otp);
	}
}
