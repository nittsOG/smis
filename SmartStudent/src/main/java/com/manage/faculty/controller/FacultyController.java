package com.manage.faculty.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.faculty.entities.Faculty;
import com.manage.faculty.service.FacultyService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "JSP/FACULTY/faculty-login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam Long id, @RequestParam String password, HttpSession session) {
        if (facultyService.validateFaculty(id, password)) {
            session.setAttribute("facultyId", id);
            return new ModelAndView("redirect:/faculty/dashboard");
        } else {
            ModelAndView mav = new ModelAndView("JSP/FACULTY/faculty-login");
            mav.addObject("error", "Invalid username or password");
            return mav;
        }
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        Long id = (Long) session.getAttribute("facultyId");
        if (id == null) {
            return new ModelAndView("redirect:/faculty/login");
        }
        ModelAndView mav = new ModelAndView("JSP/FACULTY/faculty-dashboard");
//        mav.addObject("facultyUsername", facultyUsername);
        Faculty faculty = facultyService.getFacultyById(id);
        mav.addObject("faculty", faculty);
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/faculty/login";
    }
}
