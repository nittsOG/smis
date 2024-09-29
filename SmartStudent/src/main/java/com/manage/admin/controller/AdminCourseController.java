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
import com.manage.admin.service.Admin_DepartmentService;
import com.manage.home.entities.Course;
import com.manage.home.entities.Department;

@Controller
@RequestMapping("/admin/courses")
public class AdminCourseController {

	private final Admin_CourseService adminCourseService;
	private final Admin_DepartmentService adminDepartmentService;

	@Autowired
	public AdminCourseController(@Qualifier("adminCourseServiceImpl") Admin_CourseService adminCourseService,
			@Qualifier("adminDepartmentServiceImpl") Admin_DepartmentService adminDepartmentService) {
		this.adminCourseService = adminCourseService;
		this.adminDepartmentService = adminDepartmentService;
	}

	@GetMapping
	public ModelAndView listCourses(@RequestParam(value = "departmentId", required = false) Long departmentId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Course> courses;
		if (departmentId != null) {
			courses = adminCourseService.getCoursesByDepartment(departmentId);
		} else {
			courses = adminCourseService.getAllCourses();
		}

		List<Department> departments = adminDepartmentService.getAllDepartments(); // Assuming this service method exists

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-courses");
		mav.addObject("courses", courses);
		mav.addObject("departments", departments);
		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView showCourseDetails(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Course course = adminCourseService.getCourseById(id);
		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-course-details");
		mav.addObject("course", course);
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView showEditCourseForm(@PathVariable Long id, HttpSession session) {
	    Long adminId = (Long) session.getAttribute("adminId");
	    if (adminId == null) {
	        return new ModelAndView("redirect:/admin/login");
	    }

	    Course course = adminCourseService.getCourseById(id);
	    List<Department> departments = adminDepartmentService.getAllDepartments(); // Fetch departments

	    ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-course-edit");
	    mav.addObject("course", course);
	    mav.addObject("departments", departments); // Pass departments to the view
	    return mav;
	}

	@PostMapping("/{id}/edit")
	public String updateCourse(@PathVariable Long id, @ModelAttribute("course") Course course, @RequestParam("department.departmentId") Long departmentId, HttpSession session) {
	    Long adminId = (Long) session.getAttribute("adminId");
	    if (adminId == null) {
	        return "redirect:/admin/login";
	    }

	    // Set the course ID explicitly from the path variable
	    course.setCourseId(id);

	    Department department = adminDepartmentService.getDepartmentById(departmentId);
	    course.setDepartment(department);

	    adminCourseService.updateCourse(course);
	    return "redirect:/admin/courses/{id}";
	}


	@GetMapping("/{id}/delete")
	public String deleteCourse(@PathVariable Long id, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		adminCourseService.deleteCourse(id);
		return "redirect:/admin/courses";
	}

	@GetMapping("/new")
	public ModelAndView showNewCourseForm(HttpSession session) {
	    Long adminId = (Long) session.getAttribute("adminId");
	    if (adminId == null) {
	        return new ModelAndView("redirect:/admin/login");
	    }

	    List<Department> departments = adminDepartmentService.getAllDepartments(); // Fetch departments

	    ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-course-new");
	    mav.addObject("course", new Course());
	    mav.addObject("departments", departments); // Pass departments to the view
	    return mav;
	}

	@PostMapping("/new")
	public String saveCourse(@ModelAttribute("course") Course course, @RequestParam("department.departmentId") Long departmentId, HttpSession session) {
	    Long adminId = (Long) session.getAttribute("adminId");
	    if (adminId == null) {
	        return "redirect:/admin/login";
	    }

	    Department department = adminDepartmentService.getDepartmentById(departmentId); // Fetch department by id
	    course.setDepartment(department);

	    adminCourseService.saveCourse(course);
	    return "redirect:/admin/courses";
	}
}
