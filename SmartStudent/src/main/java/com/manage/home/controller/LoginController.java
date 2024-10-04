package com.manage.home.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.chat.entities.SenderType;
import com.manage.chat.entities.User;
import com.manage.faculty.service.FacultyService;
import com.manage.student.service.StudentService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public String showLoginForm() {
        return "JSP/login";
    }

    @PostMapping
    public ModelAndView login(@RequestParam String role, @RequestParam Long id, 
                              @RequestParam String password, HttpSession session) {
        if ("student".equals(role)) {
            if (studentService.validateStudent(id, password)) {
                String studentName = studentService.getStudentById(id).getUsername(); // Get student's username
                session.setAttribute("studentId", id);
                session.setAttribute("user", new User(id, studentName, SenderType.STUDENT)); // Set user with username
                return new ModelAndView("redirect:/student/dashboard");
            } else {
                return getLoginErrorModelAndView("student");
            }
        } else if ("faculty".equals(role)) {
            if (facultyService.validateFaculty(id, password)) {
                String facultyName = facultyService.getFacultyById(id).getUsername(); // Get faculty's username
                session.setAttribute("facultyId", id);
                session.setAttribute("user", new User(id, facultyName, SenderType.FACULTY)); // Set user with username
                return new ModelAndView("redirect:/faculty/dashboard");
            } else {
                return getLoginErrorModelAndView("faculty");
            }
        } else {
            return getLoginErrorModelAndView(null);
        }
    }


    private ModelAndView getLoginErrorModelAndView(String role) {
        ModelAndView mav = new ModelAndView("JSP/login");
        mav.addObject("error", "Invalid ID or password");
        mav.addObject("role", role); // Optional: To pre-select the role if the login fails
        return mav;
    }
}
