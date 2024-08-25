package com.manage.admin.controller;

import com.manage.admin.service.Admin_StudentSemesterService;
import com.manage.student.entities.StudentSemester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/student-semesters")
public class AdminStudentSemesterController {

    private final Admin_StudentSemesterService adminStudentSemesterService;

    @Autowired
    public AdminStudentSemesterController(@Qualifier("adminStudentSemesterServiceImpl") Admin_StudentSemesterService adminStudentSemesterService) {
        this.adminStudentSemesterService = adminStudentSemesterService;
    }

    @GetMapping
    public ModelAndView listStudentSemesters(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<StudentSemester> studentSemesters = adminStudentSemesterService.getAllStudentSemesters();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semesters");
        mav.addObject("studentSemesters", studentSemesters);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showStudentSemesterDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        StudentSemester studentSemester = adminStudentSemesterService.getStudentSemesterById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-details");
        mav.addObject("studentSemester", studentSemester);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditStudentSemesterForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        StudentSemester studentSemester = adminStudentSemesterService.getStudentSemesterById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-edit");
        mav.addObject("studentSemester", studentSemester);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateStudentSemester(@PathVariable Long id, @ModelAttribute("studentSemester") StudentSemester studentSemester, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentSemesterService.updateStudentSemester(studentSemester);
        return "redirect:/admin/student-semesters/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudentSemester(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentSemesterService.deleteStudentSemester(id);
        return "redirect:/admin/student-semesters";
    }

    @GetMapping("/new")
    public ModelAndView showNewStudentSemesterForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-new");
        mav.addObject("studentSemester", new StudentSemester());
        return mav;
    }

    @PostMapping("/new")
    public String saveStudentSemester(@ModelAttribute("studentSemester") StudentSemester studentSemester, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentSemesterService.saveStudentSemester(studentSemester);
        return "redirect:/admin/student-semesters";
    }
}
