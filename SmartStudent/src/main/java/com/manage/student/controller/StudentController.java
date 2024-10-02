package com.manage.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.student.entities.Student;
import com.manage.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}


    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        Long id = (Long) session.getAttribute("studentId");
        if (id == null) {
            return new ModelAndView("redirect:/login");
        }
        ModelAndView mav = new ModelAndView("JSP/STUDENT/student-dashboard");
//        mav.addObject("studentUsername", studentUsername);
        Student student = studentService.getStudentById(id);
        mav.addObject("student", student);
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
