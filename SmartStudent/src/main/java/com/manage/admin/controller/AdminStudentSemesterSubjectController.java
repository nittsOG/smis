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

import com.manage.admin.service.Admin_StudentSemesterService;
import com.manage.admin.service.Admin_StudentSemesterSubjectService;
import com.manage.admin.service.Admin_SubjectService;
import com.manage.home.entities.Subject;
import com.manage.student.entities.StudentSemester;
import com.manage.student.entities.StudentSemesterSubject;

@Controller
@RequestMapping("/admin/student-semester-subjects")
public class AdminStudentSemesterSubjectController {

	private final Admin_StudentSemesterSubjectService adminStudentSemesterSubjectService;
	private final Admin_StudentSemesterService admin_StudentSemesterService;
	private final Admin_SubjectService admin_SubjectService;

	@Autowired
	public AdminStudentSemesterSubjectController(
			@Qualifier("adminStudentSemesterSubjectServiceImpl") Admin_StudentSemesterSubjectService adminStudentSemesterSubjectService,
			@Qualifier("adminStudentSemesterServiceImpl") Admin_StudentSemesterService admin_StudentSemesterService,
			@Qualifier("adminSubjectServiceImpl") Admin_SubjectService admin_SubjectService) {
		this.adminStudentSemesterSubjectService = adminStudentSemesterSubjectService;
		this.admin_StudentSemesterService = admin_StudentSemesterService;
		this.admin_SubjectService = admin_SubjectService;
	}

	@GetMapping
	public ModelAndView listStudentSemesterSubjects(HttpSession session,
			@RequestParam(value = "studentId", required = false) Long studentId) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<StudentSemesterSubject> studentSemesterSubjects;
		if (studentId != null) {
			studentSemesterSubjects = adminStudentSemesterSubjectService
					.getStudentSemesterSubjectsByStudentId(studentId);
		} else {
			studentSemesterSubjects = adminStudentSemesterSubjectService.getAllStudentSemesterSubjects();
		}

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-subjects");
		mav.addObject("studentSemesterSubjects", studentSemesterSubjects);
		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView showStudentSemesterSubjectDetails(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		StudentSemesterSubject studentSemesterSubject = adminStudentSemesterSubjectService
				.getStudentSemesterSubjectById(id);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-subject-details");
		mav.addObject("studentSemesterSubject", studentSemesterSubject);
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView showEditStudentSemesterSubjectForm(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		StudentSemesterSubject studentSemesterSubject = adminStudentSemesterSubjectService
				.getStudentSemesterSubjectById(id);
		List<StudentSemester> studentSemesters = admin_StudentSemesterService.getAllStudentSemesters();
		List<Subject> subjects = admin_SubjectService.getAllSubjects();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-subject-edit");
		mav.addObject("studentSemesterSubject", studentSemesterSubject);
		mav.addObject("studentSemesters", studentSemesters);
		mav.addObject("subjects", subjects);
		return mav;
	}

	@PostMapping("/{id}/edit")
	public String updateStudentSemesterSubject(@PathVariable Long id,
			@ModelAttribute("studentSemesterSubject") StudentSemesterSubject studentSemesterSubject,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		// Ensure the ID is set correctly
		studentSemesterSubject.setStudentSemesterSubjectId(id);

		adminStudentSemesterSubjectService.updateStudentSemesterSubject(studentSemesterSubject);
		return "redirect:/admin/student-semester-subjects/" + id;
	}

	@GetMapping("/{id}/delete")
	public String deleteStudentSemesterSubject(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminStudentSemesterSubjectService.deleteStudentSemesterSubject(id);
		return "redirect:/admin/student-semester-subjects";
	}

	@GetMapping("/new")
	public ModelAndView showNewStudentSemesterSubjectForm(HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<StudentSemester> studentSemesters = admin_StudentSemesterService.getAllStudentSemesters();
		List<Subject> subjects = admin_SubjectService.getAllSubjects();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-subject-new");
		mav.addObject("studentSemesterSubject", new StudentSemesterSubject());
		mav.addObject("studentSemesters", studentSemesters);
		mav.addObject("subjects", subjects);
		return mav;
	}

	@PostMapping("/new")
	public String saveStudentSemesterSubject(
			@ModelAttribute("studentSemesterSubject") StudentSemesterSubject studentSemesterSubject,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminStudentSemesterSubjectService.saveStudentSemesterSubject(studentSemesterSubject);
		return "redirect:/admin/student-semester-subjects";
	}
}
