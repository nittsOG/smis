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

import com.manage.admin.service.Admin_DivisionService;
import com.manage.admin.service.Admin_SessionService;
import com.manage.admin.service.Admin_SubjectService;
import com.manage.home.entities.Division;
import com.manage.home.entities.Session;
import com.manage.home.entities.Subject;

@Controller
@RequestMapping("/admin/sessions")
public class AdminSessionController {

	private final Admin_SessionService adminSessionService;
	private final Admin_SubjectService adminSubjectService;
	private final Admin_DivisionService adminDivisionService; // Added Division Service

	@Autowired
	public AdminSessionController(@Qualifier("adminSessionServiceImpl") Admin_SessionService adminSessionService,
			@Qualifier("adminSubjectServiceImpl") Admin_SubjectService adminSubjectService,
			@Qualifier("adminDivisionServiceImpl") Admin_DivisionService adminDivisionService) { // Injected Division
																									// Service
		this.adminSessionService = adminSessionService;
		this.adminSubjectService = adminSubjectService;
		this.adminDivisionService = adminDivisionService; // Set Division Service
	}

	@GetMapping
	public ModelAndView listSessions(@RequestParam(value = "subjectId", required = false) Long subjectId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Session> sessions;
		if (subjectId != null) {
			sessions = adminSessionService.getSessionsBySubject(subjectId);
		} else {
			sessions = adminSessionService.getAllSessions();
		}

		List<Subject> subjects = adminSubjectService.getAllSubjects();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-sessions");
		mav.addObject("sessions", sessions);
		mav.addObject("subjects", subjects);
		mav.addObject("selectedSubjectId", subjectId);
		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView showSessionDetails(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Session sessionDetail = adminSessionService.getSessionById(id);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-session-details");
		mav.addObject("session", sessionDetail);
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView showEditSessionForm(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Session sessionDetail = adminSessionService.getSessionById(id);
		List<Subject> subjects = adminSubjectService.getAllSubjects();
		List<Division> divisions = adminDivisionService.getAllDivisions(); // Fetch Divisions

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-session-edit");
		mav.addObject("session", sessionDetail);
		mav.addObject("subjects", subjects);
		mav.addObject("divisions", divisions); // Pass Divisions to View
		return mav;
	}

	@PostMapping("/{id}/edit")
	public String updateSession(@PathVariable Long id, @RequestParam("sessionDate") String sessionDate,
			@RequestParam("sessionType") String sessionType, @RequestParam("startTime") String startTime,
			@RequestParam("endTime") String endTime, @RequestParam("subjectId") Long subjectId,
			@RequestParam("divisionId") Long divisionId, @RequestParam("facultyId") Long facultyId,
			HttpSession httpSession) {
		Long adminId = (Long) httpSession.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

		try {
			Date parsedSessionDate = dateFormat.parse(sessionDate);
			Date parsedStartTime = timeFormat.parse(startTime);
			Date parsedEndTime = timeFormat.parse(endTime);

			Session session = adminSessionService.getSessionById(id);
			session.setSessionDate(parsedSessionDate);
			session.setSessionType(sessionType);
			session.setStartTime(parsedStartTime);
			session.setEndTime(parsedEndTime);
			session.setDivision_Id(divisionId);
			session.setFaculty_Id(facultyId);

			Subject subject = adminSubjectService.getSubjectById(subjectId);
			session.setSubject(subject);

			adminSessionService.updateSession(session);

		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/admin/sessions/" + id + "/edit?error=Invalid date or time format";
		}

		return "redirect:/admin/sessions/" + id;
	}

	@GetMapping("/{id}/delete")
	public String deleteSession(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminSessionService.deleteSession(id);
		return "redirect:/admin/sessions";
	}

	@GetMapping("/new")
	public ModelAndView showNewSessionForm(HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Subject> subjects = adminSubjectService.getAllSubjects();
		List<Division> divisions = adminDivisionService.getAllDivisions(); // Fetch Divisions

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-session-new");
		mav.addObject("subjects", subjects);
		mav.addObject("divisions", divisions); // Pass Divisions to View
		return mav;
	}

	@PostMapping("/new")
	public String saveSession(@RequestParam("sessionDate") String sessionDate,
			@RequestParam("sessionType") String sessionType, @RequestParam("startTime") String startTime,
			@RequestParam("endTime") String endTime, @RequestParam("subjectId") Long subjectId,
			@RequestParam("divisionId") Long divisionId, @RequestParam("facultyId") Long facultyId,
			HttpSession httpSession) {
		Long adminId = (Long) httpSession.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

		try {
			Date parsedSessionDate = dateFormat.parse(sessionDate);
			Date parsedStartTime = timeFormat.parse(startTime);
			Date parsedEndTime = timeFormat.parse(endTime);

			Session session = new Session();
			session.setSessionDate(parsedSessionDate);
			session.setSessionType(sessionType);
			session.setStartTime(parsedStartTime);
			session.setEndTime(parsedEndTime);
			session.setDivision_Id(divisionId);
			session.setFaculty_Id(facultyId);

			Subject subject = adminSubjectService.getSubjectById(subjectId);
			session.setSubject(subject);

			adminSessionService.saveSession(session);

		} catch (ParseException e) {
			e.printStackTrace();
			return "redirect:/admin/sessions/new?error=Invalid date or time format";
		}

		return "redirect:/admin/sessions";
	}
}
