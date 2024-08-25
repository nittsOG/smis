package com.manage.admin.controller;

import com.manage.admin.service.Admin_CourseService;
import com.manage.home.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/courses")
public class AdminCourseController {

    private final Admin_CourseService adminCourseService;

    @Autowired
    public AdminCourseController(@Qualifier("adminCourseServiceImpl") Admin_CourseService adminCourseService) {
        this.adminCourseService = adminCourseService;
    }

    @GetMapping
    public ModelAndView listCourses(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Course> courses = adminCourseService.getAllCourses();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-courses");
        mav.addObject("courses", courses);
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
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-course-edit");
        mav.addObject("course", course);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateCourse(@PathVariable Long id, @ModelAttribute("course") Course course, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

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

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-course-new");
        mav.addObject("course", new Course());
        return mav;
    }

    @PostMapping("/new")
    public String saveCourse(@ModelAttribute("course") Course course, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminCourseService.saveCourse(course);
        return "redirect:/admin/courses";
    }
}
