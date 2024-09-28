package com.manage.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.admin.service.Admin_SemesterService;
import com.manage.admin.service.Admin_StudentSemesterService;
import com.manage.admin.service.Admin_StudentService;
import com.manage.home.entities.Semester;
import com.manage.student.entities.Student;
import com.manage.student.entities.StudentSemester;

@Controller
@RequestMapping("/admin/student-semesters")
public class AdminStudentSemesterController {

	private final Admin_StudentSemesterService adminStudentSemesterService;
	private final Admin_StudentService admin_StudentService;
	private final Admin_SemesterService admin_SemesterService;

	@Autowired
	public AdminStudentSemesterController(
			@Qualifier("adminStudentSemesterServiceImpl") Admin_StudentSemesterService adminStudentSemesterService,
			@Qualifier("adminStudentServiceImpl") Admin_StudentService admin_StudentService,
			@Qualifier("adminSemesterServiceImpl") Admin_SemesterService admin_SemesterService) {
		this.adminStudentSemesterService = adminStudentSemesterService;
		this.admin_StudentService = admin_StudentService;
		this.admin_SemesterService = admin_SemesterService;
	}

	@GetMapping
	public ModelAndView listStudentSemesters(@RequestParam(value = "studentId", required = false) Long studentId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<StudentSemester> studentSemesters;
		if (studentId != null) {
			// Filter by student
			studentSemesters = adminStudentSemesterService.getStudentSemestersByStudentId(studentId);
		} else {
			studentSemesters = adminStudentSemesterService.getAllStudentSemesters();
		}

		// Fetch list of all students for dropdown
		List<Student> students = admin_StudentService.getAllStudents();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semesters");
		mav.addObject("studentSemesters", studentSemesters);
		mav.addObject("students", students); // For dropdown filter
		mav.addObject("selectedStudentId", studentId); // To retain selected student in the dropdown
		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView showStudentSemesterDetails(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		StudentSemester studentSemester = adminStudentSemesterService.getStudentSemesterById(id);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-details");
		mav.addObject("studentSemester", studentSemester);
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView showEditStudentSemesterForm(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		StudentSemester studentSemester = adminStudentSemesterService.getStudentSemesterById(id);
		List<Student> students = admin_StudentService.getAllStudents();
		List<Semester> semesters = admin_SemesterService.getAllSemesters();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-edit");
		mav.addObject("studentSemester", studentSemester);
		mav.addObject("students", students); // Dropdown list
		mav.addObject("semesters", semesters); // Dropdown list
		return mav;
	}

	@PostMapping("/{id}/edit")
	public String updateStudentSemester(@PathVariable Long id,
			@ModelAttribute("studentSemester") StudentSemester studentSemester,
			@RequestParam("semesterId") Long semesterId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		// Fetch the existing StudentSemester entity
		StudentSemester existingStudentSemester = adminStudentSemesterService.getStudentSemesterById(id);

		// Ensure the existing entity is updated with new values
		existingStudentSemester.setStudent(studentSemester.getStudent()); // Assuming you're setting the student
																			// reference properly
		Semester semester = admin_SemesterService.getSemesterById(semesterId);
		existingStudentSemester.setSemester(semester); // Set the fully loaded semester object

		adminStudentSemesterService.updateStudentSemester(existingStudentSemester);
		return "redirect:/admin/student-semesters";
	}

	@GetMapping("/{id}/delete")
	public String deleteStudentSemester(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminStudentSemesterService.deleteStudentSemester(id);
		return "redirect:/admin/student-semesters";
	}

	@GetMapping("/new")
	public ModelAndView showNewStudentSemesterForm(HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Student> students = admin_StudentService.getAllStudents();
		List<Semester> semesters = admin_SemesterService.getAllSemesters();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-new");
		mav.addObject("studentSemester", new StudentSemester());
		mav.addObject("students", students); // Dropdown list
		mav.addObject("semesters", semesters); // Dropdown list
		return mav;
	}

	@PostMapping("/new")
	public String saveStudentSemester(@ModelAttribute("studentSemester") StudentSemester studentSemester,
			@RequestParam("semesterId") Long semesterId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		// Fetch the full Semester entity
		Semester semester = admin_SemesterService.getSemesterById(semesterId);
		studentSemester.setSemester(semester); // Set the fully loaded semester object

		adminStudentSemesterService.saveStudentSemester(studentSemester);
		return "redirect:/admin/student-semesters";
	}
}
