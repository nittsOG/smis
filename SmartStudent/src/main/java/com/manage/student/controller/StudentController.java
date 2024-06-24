package com.manage.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "JSP/STUDENT/student-login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (studentService.validateStudent(username, password)) {
            session.setAttribute("studentUsername", username);
            return new ModelAndView("redirect:/student/dashboard");
        } else {
            ModelAndView mav = new ModelAndView("student-login");
            mav.addObject("error", "Invalid username or password");
            return mav;
        }
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        String studentUsername = (String) session.getAttribute("studentUsername");
        if (studentUsername == null) {
            return new ModelAndView("redirect:/student/login");
        }
        ModelAndView mav = new ModelAndView("JSP/STUDENT/student-dashboard");
        mav.addObject("studentUsername", studentUsername);
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/student/login";
    }
}
