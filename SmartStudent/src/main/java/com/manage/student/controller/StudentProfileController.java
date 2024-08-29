package com.manage.student.controller;

import com.manage.student.entities.Student;
import com.manage.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student/profile")
public class StudentProfileController {

    private StudentService studentService;

    @Autowired
    public StudentProfileController(@Qualifier("studentServiceImpl")StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ModelAndView viewProfile(HttpSession session) {
        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId == null) {
            return new ModelAndView("redirect:/login");
        }
        Student student = studentService.getStudentById(studentId);
        ModelAndView mav = new ModelAndView("JSP/STUDENT/student-profile");
        mav.addObject("student", student);
        return mav;
    }
}
