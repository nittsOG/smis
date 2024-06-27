package com.manage.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/login")
    public String showLoginForm() {
        return "JSP/STUDENT/student-login";
    }

    @PostMapping("/login")
    public ModelAndView login( @RequestParam Long id, @RequestParam String password, HttpSession session) {
        if (studentService.validateStudent(id, password)) {
            session.setAttribute("studentId", id);
            return new ModelAndView("redirect:/student/dashboard");
        } else {
            ModelAndView mav = new ModelAndView("student-login");
            mav.addObject("error", "Invalid id or password");
            return mav;
        }
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        Long id = (Long) session.getAttribute("studentId");
        if (id == null) {
            return new ModelAndView("redirect:/student/login");
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
        return "redirect:/student/login";
    }
}
