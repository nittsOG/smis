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

import com.manage.admin.service.Admin_CourseService;
import com.manage.admin.service.Admin_SubjectService;
import com.manage.home.entities.Course;
import com.manage.home.entities.Subject;

@Controller
@RequestMapping("/admin/subjects")
public class AdminSubjectController {

	private final Admin_SubjectService subjectService;
	private final Admin_CourseService admin_CourseService;

	@Autowired
	public AdminSubjectController(@Qualifier("adminSubjectServiceImpl") Admin_SubjectService subjectService,
			@Qualifier("adminCourseServiceImpl") Admin_CourseService admin_CourseService) {
		this.subjectService = subjectService;
		this.admin_CourseService = admin_CourseService;
	}

	@GetMapping
	public ModelAndView listSubjects(@RequestParam(value = "courseId", required = false) Long courseId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Course> courses = admin_CourseService.getAllCourses(); // Fetch all courses for the dropdown
		List<Subject> subjects;

		if (courseId != null) {
			subjects = subjectService.getSubjectsByCourse(courseId);
		} else {
			subjects = subjectService.getAllSubjects();
		}

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-subjects");
		mav.addObject("subjects", subjects);
		mav.addObject("courses", courses);
		mav.addObject("selectedCourseId", courseId);
		return mav;
	}

	// Show subject details by ID
	@GetMapping("/{id}")
	public ModelAndView showSubjectDetails(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Subject subject = subjectService.getSubjectById(id);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-subject-details");
		mav.addObject("subject", subject);
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView showEditSubjectForm(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Subject subject = subjectService.getSubjectById(id);
		List<Course> courses = admin_CourseService.getAllCourses();
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-subject-edit");
		mav.addObject("courses", courses);
		mav.addObject("subject", subject);
		return mav;
	}

	// Process edit form submission
	@PostMapping("/{id}/edit")
	public String updateSubject(@PathVariable Long id, @ModelAttribute("subject") Subject formSubject,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		// Fetch the subject from the database
		Subject subject = subjectService.getSubjectById(id);
		if (subject == null) {
			return "redirect:/admin/subjects"; // Handle case when subject doesn't exist
		}

		// Update subject details
		subject.setName(formSubject.getName());
		subject.setCode(formSubject.getCode());
		subject.setDescription(formSubject.getDescription());
		subject.setCourse(formSubject.getCourse()); // Set course if it's updated

		// Now update the subject
		subjectService.updateSubject(subject);

		return "redirect:/admin/subjects";
	}

	// Delete subject by ID
	@GetMapping("/{id}/delete")
	public String deleteSubject(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		subjectService.deleteSubject(id);
		return "redirect:/admin/subjects";
	}

	// Add and Edit views should include the list of courses:
	@GetMapping("/new")
	public ModelAndView showNewSubjectForm(HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Course> courses = admin_CourseService.getAllCourses();
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-subject-new");
		mav.addObject("courses", courses);
		mav.addObject("subject", new Subject());
		return mav;
	}

	@PostMapping("/new")
	public String saveSubject(@RequestParam("name") String name, @RequestParam("code") String code,
			@RequestParam("description") String description, @RequestParam("course.courseId") Long courseId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		// Fetch the course by ID
		Course course = admin_CourseService.getCourseById(courseId);

		// Create a new subject and set its properties
		Subject subject = new Subject();
		subject.setName(name);
		subject.setCode(code);
		subject.setDescription(description);
		subject.setCourse(course); // Set the fetched course

		// Save the subject
		try {
			subjectService.saveSubject(subject);
		} catch (Exception e) {
			e.printStackTrace(); // Log the error for debugging
			// Handle the error appropriately (e.g., return an error page or message)
		}

		return "redirect:/admin/subjects";
	}

}
