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
import com.manage.admin.service.Admin_SemesterService;
import com.manage.home.entities.Course;
import com.manage.home.entities.Semester;

@Controller
@RequestMapping("/admin/semesters")
public class AdminSemesterController {

    private final Admin_SemesterService adminSemesterService;
    private final Admin_CourseService adminCourseService;

    @Autowired
    public AdminSemesterController(
            @Qualifier("adminSemesterServiceImpl") Admin_SemesterService adminSemesterService,
            @Qualifier("adminCourseServiceImpl") Admin_CourseService adminCourseService) {
        this.adminSemesterService = adminSemesterService;
        this.adminCourseService = adminCourseService;
    }

    @GetMapping
    public ModelAndView listSemesters(@RequestParam(value = "courseId", required = false) Long courseId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Semester> semesters;
        if (courseId != null) {
            semesters = adminSemesterService.getSemestersByCourseId(courseId);
        } else {
            semesters = adminSemesterService.getAllSemesters();
        }
        

        List<Course> courses = adminCourseService.getAllCourses();
        

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semesters");
        mav.addObject("semesters", semesters);
        mav.addObject("courses", courses); // Add courses for dropdown
        mav.addObject("selectedCourseId", courseId); // For pre-selecting the course

        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showSemesterDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Semester semester = adminSemesterService.getSemesterById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-details");
        mav.addObject("semester", semester);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditSemesterForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Semester semester = adminSemesterService.getSemesterById(id);
        List<Course> courses = adminCourseService.getAllCourses(); // Fetch courses for dropdown

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-edit");
        mav.addObject("semester", semester);
        mav.addObject("courses", courses); // Add courses for dropdown
        return mav;
    }


    @PostMapping("/{id}/edit")
    public String updateSemester(@PathVariable Long id, @ModelAttribute("semester") Semester semester, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterService.updateSemester(semester);
        return "redirect:/admin/semesters/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteSemester(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterService.deleteSemester(id);
        return "redirect:/admin/semesters";
    }

    @GetMapping("/new")
    public ModelAndView showNewSemesterForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Course> courses = adminCourseService.getAllCourses(); // Fetch courses for dropdown

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-semester-new");
        mav.addObject("semester", new Semester());
        mav.addObject("courses", courses); // Add courses for dropdown
        return mav;
    }


    @PostMapping("/new")
    public String saveSemester(@ModelAttribute("semester") Semester semester, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSemesterService.saveSemester(semester);
        return "redirect:/admin/semesters";
    }
}
