package com.manage.faculty.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
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

import com.manage.faculty.service.FacultyAttendanceService;
import com.manage.faculty.service.FacultyDivisionService;
import com.manage.faculty.service.FacultySubjectService;
import com.manage.faculty.service.Faculty_StudentService;
import com.manage.home.entities.Attendance;
import com.manage.home.entities.AttendanceStatus;
import com.manage.home.entities.Division;
import com.manage.home.entities.Session;
import com.manage.home.entities.Subject;

@Controller
@RequestMapping("/faculty/attendance")
public class FacultyAttendanceController {

	private FacultyAttendanceService attendanceService;
	private FacultyDivisionService divisionService;
	private FacultySubjectService subjectService;
	private Faculty_StudentService studentService;

	@Autowired
	public FacultyAttendanceController(
			@Qualifier("facultyAttendanceServiceImpl") FacultyAttendanceService attendanceService,
			@Qualifier("facultyDivisionServiceImpl") FacultyDivisionService divisionService,
			@Qualifier("facultySubjectServiceImpl") FacultySubjectService subjectService,
			@Qualifier("facultyStudentServiceImpl") Faculty_StudentService studentService) {
		this.attendanceService = attendanceService;
		this.divisionService = divisionService;
		this.subjectService = subjectService;
		this.studentService = studentService;
	}

	

//*****************************************************************************************

	// GET method to display form with dropdowns for selecting division and subject,
	// and to show relevant sessions
	@GetMapping("/sessions/map")
	public ModelAndView showSessionsAndAttendance(HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return new ModelAndView("redirect:/login");
		}

		ModelAndView mav = new ModelAndView("JSP/FACULTY/sessions-attendance-map");

		// Fetch list of divisions and subjects related to the faculty
		List<Division> divisions = divisionService.getDivisionsByFacultyId(facultyId);
		List<Subject> subjects = subjectService.getSubjectsByFacultyId(facultyId);

		mav.addObject("divisions", divisions);
		mav.addObject("subjects", subjects);
		mav.addObject("selectedDivision", new Division()); // Empty object for form binding
		mav.addObject("selectedSubject", new Subject()); // Empty object for form binding

	    System.out.println("Divisions: " + divisions);
	    System.out.println("Subjects: " + subjects);

		return mav;
	}

	// POST method to display relevant sessions and attendance map
	@PostMapping("/sessions/map")
	public ModelAndView showSessionAttendanceMap(HttpSession session, Long divisionId, Long subjectId) {
	    Long facultyId = (Long) session.getAttribute("facultyId");
	    if (facultyId == null) {
	        return new ModelAndView("redirect:/login");
	    }

	    ModelAndView mav = new ModelAndView("JSP/FACULTY/sessions-attendance-map");

	    // Fetch the map of sessions to attendance based on division and subject
	    Map<Session, List<Attendance>> sessionAttendanceMap = attendanceService.getSessionAttendanceMap(facultyId, divisionId, subjectId);

	    // Sort the sessions by sessionId
	    sessionAttendanceMap = sessionAttendanceMap.entrySet()
	        .stream()
	        .sorted(Map.Entry.comparingByKey(Comparator.comparing(Session::getSessionId)))
	        .collect(Collectors.toMap(
	            Map.Entry::getKey,
	            Map.Entry::getValue,
	            (oldValue, newValue) -> oldValue,
	            LinkedHashMap::new)); // Preserving the order

	    // Fetch list of divisions and subjects again for the dropdowns
	    List<Division> divisions = divisionService.getDivisionsByFacultyId(facultyId);
	    List<Subject> subjects = subjectService.getSubjectsByFacultyId(facultyId);

	    mav.addObject("divisions", divisions);
	    mav.addObject("subjects", subjects);
	    mav.addObject("sessionAttendanceMap", sessionAttendanceMap);

	    return mav;
	}

	// View specific attendance session details for editing
	@GetMapping("/sessions/{sessionId}/view")
	public ModelAndView viewAttendance(@PathVariable("sessionId") Long sessionId, HttpSession session) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return new ModelAndView("redirect:/login");
		}

		ModelAndView mav = new ModelAndView("JSP/FACULTY/view-attendance");

		// Fetch attendance details for the given session
		List<Attendance> attendanceList = attendanceService.getAttendanceBySessionId(sessionId);

		mav.addObject("sessionId", sessionId);
		mav.addObject("attendanceList", attendanceList); // Pass the actual attendance data to the view

		return mav;
	}

	// Edit and update attendance for a session
	@PostMapping("/sessions/{sessionId}/edit")
	public ModelAndView updateAttendance(@PathVariable("sessionId") Long sessionId, HttpSession session,
			HttpServletRequest request) {
		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return new ModelAndView("redirect:/login");
		}

		// Fetch attendance details for the session
		List<Attendance> attendanceList = attendanceService.getAttendanceBySessionId(sessionId);

		// Loop through each attendance and update status based on checkbox
		for (Attendance attendance : attendanceList) {
			String checkboxValue = request.getParameter("attendanceStatus_" + attendance.getAttendanceId());
			if ("PRESENT".equals(checkboxValue)) {
				attendance.setStatus(AttendanceStatus.PRESENT);
			} else {
				attendance.setStatus(AttendanceStatus.ABSENT);
			}
			attendanceService.updateAttendance(attendance); // Save updated attendance
		}

		ModelAndView mav = new ModelAndView("redirect:/faculty/attendance/sessions/" + sessionId + "/view");
		mav.addObject("message", "Attendance updated successfully!");

		return mav;
	}
	
    // GET method to display form for creating a new session
	@GetMapping("/sessions/new")
	public ModelAndView showCreateSessionForm(HttpSession session) {
	    Long facultyId = (Long) session.getAttribute("facultyId");
	    if (facultyId == null) {
	        return new ModelAndView("redirect:/login");
	    }

	    ModelAndView mav = new ModelAndView("JSP/FACULTY/create-session");

	    // Fetch the list of divisions and subjects for the dropdowns
		List<Division> divisions = divisionService.getDivisionsByFacultyId(facultyId);
		List<Subject> subjects = subjectService.getSubjectsByFacultyId(facultyId);

		mav.addObject("divisions", divisions);
		mav.addObject("subjects", subjects);
	    mav.addObject("session", new Session());  // To bind form data

	    System.out.println("Divisions: " + divisions.toString());
	    System.out.println("Subjects: " + subjects.toString());

	    return mav;
	}


    // POST method to create a session and default attendance
	@PostMapping("/sessions/newsession")
	public ModelAndView createSessionAndAttendance(
	    @RequestParam("divisionId") Long divisionId,
	    @RequestParam("subjectId") Long subjectId,
	    @RequestParam("sessionDate") String sessionDate,
	    @RequestParam("sessionType") String sessionType,
	    @RequestParam("startTime") String startTime,
	    @RequestParam("endTime") String endTime,
	    HttpSession httpSession) {

	    Long facultyId = (Long) httpSession.getAttribute("facultyId");
	    if (facultyId == null) {
	        return new ModelAndView("redirect:/login");
	    }

	    // Convert the date and time input strings to appropriate Date/Time objects
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	    try {
	        Date parsedSessionDate = dateFormat.parse(sessionDate);
	        Date parsedStartTime = timeFormat.parse(startTime);
	        Date parsedEndTime = timeFormat.parse(endTime);

	        // Create the new session object
	        Session session = new Session();
	        session.setDivision_Id(divisionId);
	        session.setFaculty_Id(facultyId);
	        session.setSessionDate(parsedSessionDate);
	        session.setSessionType(sessionType);
	        session.setStartTime(parsedStartTime);
	        session.setEndTime(parsedEndTime);

	        // Set subject by fetching it from the service
	        Subject subject = subjectService.getSubjectById(subjectId);
	        session.setSubject(subject);

	        // Save the session and default attendance
	        attendanceService.createSessionWithAttendance(session);

	        // Redirect to the session listing page or the attendance overview page
	        return new ModelAndView("redirect:/faculty/attendance/sessions/map");

	    } catch (ParseException e) {
	        // Handle the parsing exception for date/time formats
	        ModelAndView mav = new ModelAndView("JSP/FACULTY/create-session");
	        mav.addObject("error", "Invalid date/time format. Please use the correct format.");
	        return mav;
	    }
	}



}
