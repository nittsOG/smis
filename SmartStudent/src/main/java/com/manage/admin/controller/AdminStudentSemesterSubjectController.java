package com.manage.admin.controller;

import com.manage.admin.service.Admin_StudentSemesterSubjectService;
import com.manage.student.entities.StudentSemesterSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/student-semester-subjects")
public class AdminStudentSemesterSubjectController {

    private final Admin_StudentSemesterSubjectService adminStudentSemesterSubjectService;

    @Autowired
    public AdminStudentSemesterSubjectController(@Qualifier("adminStudentSemesterSubjectServiceImpl") Admin_StudentSemesterSubjectService adminStudentSemesterSubjectService) {
        this.adminStudentSemesterSubjectService = adminStudentSemesterSubjectService;
    }

    @GetMapping
    public ModelAndView listStudentSemesterSubjects(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<StudentSemesterSubject> studentSemesterSubjects = adminStudentSemesterSubjectService.getAllStudentSemesterSubjects();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-subjects");
        mav.addObject("studentSemesterSubjects", studentSemesterSubjects);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showStudentSemesterSubjectDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        StudentSemesterSubject studentSemesterSubject = adminStudentSemesterSubjectService.getStudentSemesterSubjectById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-subject-details");
        mav.addObject("studentSemesterSubject", studentSemesterSubject);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditStudentSemesterSubjectForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        StudentSemesterSubject studentSemesterSubject = adminStudentSemesterSubjectService.getStudentSemesterSubjectById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-subject-edit");
        mav.addObject("studentSemesterSubject", studentSemesterSubject);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateStudentSemesterSubject(@PathVariable Long id, @ModelAttribute("studentSemesterSubject") StudentSemesterSubject studentSemesterSubject, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentSemesterSubjectService.updateStudentSemesterSubject(studentSemesterSubject);
        return "redirect:/admin/student-semester-subjects/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudentSemesterSubject(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentSemesterSubjectService.deleteStudentSemesterSubject(id);
        return "redirect:/admin/student-semester-subjects";
    }

    @GetMapping("/new")
    public ModelAndView showNewStudentSemesterSubjectForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-semester-subject-new");
        mav.addObject("studentSemesterSubject", new StudentSemesterSubject());
        return mav;
    }

    @PostMapping("/new")
    public String saveStudentSemesterSubject(@ModelAttribute("studentSemesterSubject") StudentSemesterSubject studentSemesterSubject, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentSemesterSubjectService.saveStudentSemesterSubject(studentSemesterSubject);
        return "redirect:/admin/student-semester-subjects";
    }
}
