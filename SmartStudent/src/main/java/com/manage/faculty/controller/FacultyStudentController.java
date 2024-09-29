package com.manage.faculty.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.common.EncodingUtils;
import com.manage.faculty.service.Faculty_FacultyDivisionService;
import com.manage.faculty.service.Faculty_StudentService;
import com.manage.home.entities.Division;
import com.manage.student.entities.Student;

@Controller
@RequestMapping("/faculty")
public class FacultyStudentController {
	private Faculty_StudentService faculty_StudentService;
	private Faculty_FacultyDivisionService faculty_FacultyDivisionService;

	public FacultyStudentController(
			@Qualifier("facultyStudentServiceImpl") Faculty_StudentService faculty_StudentService,
			@Qualifier("facultyFacultyDivisionServiceImpl") Faculty_FacultyDivisionService faculty_FacultyDivisionService) {
		this.faculty_StudentService = faculty_StudentService;
		this.faculty_FacultyDivisionService = faculty_FacultyDivisionService;
	}

	@GetMapping("/students")
	public ModelAndView getstudentlist(@RequestParam(value = "divisionId", required = false) Long divisionId,
			HttpSession session) {

		Long facultyId = (Long) session.getAttribute("facultyId");
		if (facultyId == null) {
			return new ModelAndView("redirect:/login");
		}

		List<Student> students;
		if (divisionId != null) {
			students = faculty_StudentService.getStudentsByDivision(divisionId);
		} else {
			students = faculty_StudentService.getAllStudents();
		}

		students.forEach(student -> {
			if (student.getPhoto() != null) {
				student.setPhotoBase64(EncodingUtils.toBase64(student.getPhoto()));
			}
		});

		List<Division> facultyDivision = faculty_FacultyDivisionService.getAllFacultyDivisionsbyAcultyId(facultyId);

		ModelAndView mav = new ModelAndView("JSP/FACULTY/faculty-students");
		mav.addObject("students", students);
		mav.addObject("Divisions", facultyDivision);
		mav.addObject("selectedDivisionId", divisionId); // Add selected division ID to pass to the view
		return mav;
	}

}
