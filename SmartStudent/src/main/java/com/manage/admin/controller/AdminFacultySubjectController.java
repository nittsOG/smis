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

import com.manage.admin.service.Admin_FacultyService;
import com.manage.admin.service.Admin_FacultySubjectService;
import com.manage.admin.service.Admin_SubjectService;
import com.manage.faculty.entities.Faculty;
import com.manage.faculty.entities.FacultySubject;
import com.manage.home.entities.Subject;

@Controller
@RequestMapping("/admin/facultySubjects")
public class AdminFacultySubjectController {

	private final Admin_FacultySubjectService adminFacultySubjectService;
	private final Admin_SubjectService subjectService;
	private final Admin_FacultyService admin_FacultyService;

	@Autowired
	public AdminFacultySubjectController(
			@Qualifier("adminFacultySubjectServiceImpl") Admin_FacultySubjectService adminFacultySubjectService,
			@Qualifier("adminSubjectServiceImpl") Admin_SubjectService subjectService,
			@Qualifier("adminFacultyServiceImpl") Admin_FacultyService admin_FacultyService) {
		this.adminFacultySubjectService = adminFacultySubjectService;
		this.subjectService = subjectService;
		this.admin_FacultyService = admin_FacultyService;
	}

	@GetMapping
	public ModelAndView listFacultySubjects(@RequestParam(value = "facultyId", required = false) Long facultyId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<FacultySubject> facultySubjects;

		if (facultyId != null) {
			facultySubjects = adminFacultySubjectService.getFacultySubjectsByFacultyId(facultyId);
		} else {
			facultySubjects = adminFacultySubjectService.getAllFacultySubjects();
		}

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultySubjects");
		mav.addObject("facultySubjects", facultySubjects);
		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView showFacultySubjectDetails(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		FacultySubject facultySubject = adminFacultySubjectService.getFacultySubjectById(id);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultySubject-details");
		mav.addObject("facultySubject", facultySubject);
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView showEditFacultySubjectForm(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		FacultySubject facultySubject = adminFacultySubjectService.getFacultySubjectById(id);
		List<Subject> subjects = subjectService.getAllSubjects(); // Fetch list of subjects

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultySubject-edit");
		mav.addObject("facultySubject", facultySubject);
		mav.addObject("subjects", subjects); // Pass the list of subjects to the view
		return mav;
	}

	@PostMapping("/{id}/edit")
	public String updateFacultySubject(@PathVariable Long id, @RequestParam("subjectId") Long subjectId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		FacultySubject facultySubject = adminFacultySubjectService.getFacultySubjectById(id);
		Subject subject = subjectService.getSubjectById(subjectId);

		facultySubject.setSubject(subject);

		adminFacultySubjectService.updateFacultySubject(facultySubject);
		return "redirect:/admin/facultySubjects/{id}";
	}

	@GetMapping("/{id}/delete")
	public String deleteFacultySubject(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminFacultySubjectService.deleteFacultySubject(id);
		return "redirect:/admin/facultySubjects";
	}

	@GetMapping("/new")
	public ModelAndView showNewFacultySubjectForm(HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Subject> subjects = subjectService.getAllSubjects(); // Fetch list of subjects
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-facultySubject-new");
		mav.addObject("facultySubject", new FacultySubject());
		mav.addObject("subjects", subjects); // Pass the list of subjects to the view
		return mav;
	}

	@PostMapping("/new")
	public String saveFacultySubject(@RequestParam("facultyId") Long facultyId,
			@RequestParam("subjectId") Long subjectId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		FacultySubject facultySubject = new FacultySubject();
		Faculty faculty = admin_FacultyService.getFacultyById(facultyId);
		Subject subject = subjectService.getSubjectById(subjectId);

		facultySubject.setFaculty(faculty);
		facultySubject.setSubject(subject);

		adminFacultySubjectService.saveFacultySubject(facultySubject);
		return "redirect:/admin/facultySubjects";
	}

}
