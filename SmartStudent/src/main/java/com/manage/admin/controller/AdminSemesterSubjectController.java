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
import com.manage.admin.service.Admin_SemesterSubjectService;
import com.manage.admin.service.Admin_SubjectService;
import com.manage.home.entities.Semester;
import com.manage.home.entities.SemesterSubject;
import com.manage.home.entities.Subject;

@Controller
@RequestMapping("/admin/semester-subjects")
public class AdminSemesterSubjectController {

	private final Admin_SemesterSubjectService adminSemesterSubjectService;
	private final Admin_SubjectService admin_SubjectService;
	private final Admin_SemesterService admin_SemesterService;

	@Autowired
	public AdminSemesterSubjectController(
			@Qualifier("adminSemesterSubjectServiceImpl") Admin_SemesterSubjectService adminSemesterSubjectService,
			@Qualifier("adminSubjectServiceImpl") Admin_SubjectService admin_SubjectService,
			@Qualifier("adminSemesterServiceImpl") Admin_SemesterService admin_SemesterService) {
		this.adminSemesterSubjectService = adminSemesterSubjectService;
		this.admin_SubjectService = admin_SubjectService;
		this.admin_SemesterService = admin_SemesterService;
	}

	@GetMapping
	public ModelAndView listSemesterSubjects(@RequestParam(value = "subjectId", required = false) Long subjectId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<SemesterSubject> semesterSubjects;
		if (subjectId != null) {
			semesterSubjects = adminSemesterSubjectService.getSemesterSubjectsBySubjectId(subjectId);
		} else {
			semesterSubjects = adminSemesterSubjectService.getAllSemesterSubjects();
		}

		List<Subject> subjects = admin_SubjectService.getAllSubjects(); // For subject filter dropdown
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-subjects");
		mav.addObject("semesterSubjects", semesterSubjects);
		mav.addObject("subjects", subjects);
		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView showSemesterSubjectDetails(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		SemesterSubject semesterSubject = adminSemesterSubjectService.getSemesterSubjectById(id);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-subject-details");
		mav.addObject("semesterSubject", semesterSubject);
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView showEditSemesterSubjectForm(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		SemesterSubject semesterSubject = adminSemesterSubjectService.getSemesterSubjectById(id);
		List<Semester> semesters = admin_SemesterService.getAllSemesters(); // Fetch all semesters
		List<Subject> subjects = admin_SubjectService.getAllSubjects(); // Fetch all subjects

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-subject-edit");
		mav.addObject("semesterSubject", semesterSubject);
		mav.addObject("semesters", semesters);
		mav.addObject("subjects", subjects);
		return mav;
	}

	@PostMapping("/{id}/edit")
	public String updateSemesterSubject(@PathVariable Long id,
			@ModelAttribute("semesterSubject") SemesterSubject semesterSubject, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminSemesterSubjectService.updateSemesterSubject(semesterSubject);
		return "redirect:/admin/semester-subjects/{id}";
	}

	@GetMapping("/{id}/delete")
	public String deleteSemesterSubject(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminSemesterSubjectService.deleteSemesterSubject(id);
		return "redirect:/admin/semester-subjects";
	}

	@GetMapping("/new")
	public ModelAndView showNewSemesterSubjectForm(HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Subject> subjects = admin_SubjectService.getAllSubjects();
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-subject-new");
		mav.addObject("semesterSubject", new SemesterSubject());
		mav.addObject("subjects", subjects);
		return mav;
	}

	@PostMapping("/new")
	public String saveSemesterSubject(@ModelAttribute("semesterSubject") SemesterSubject semesterSubject,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminSemesterSubjectService.saveSemesterSubject(semesterSubject);
		return "redirect:/admin/semester-subjects";
	}
}
