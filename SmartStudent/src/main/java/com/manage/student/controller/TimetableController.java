package com.manage.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.student.entities.Student;
import com.manage.student.service.StudentService;
import com.manage.student.service.Student_TimetableService;

import javax.servlet.http.HttpSession;

@Controller
public class TimetableController {

    private Student_TimetableService timetableService;
    private StudentService studentService;
    
    @Autowired
    public TimetableController(@Qualifier("studentTimetableServiceImpl") Student_TimetableService timetableService, @Qualifier("studentServiceImpl") StudentService studentService) {
        this.timetableService = timetableService;
        this.studentService = studentService;
    }

    @GetMapping("/student/timetable")
    public ModelAndView showTimetable(HttpSession session) {

        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId == null) {
            return new ModelAndView("redirect:/student/login");
        }

        Student student = studentService.getStudentById(studentId);
        ModelAndView mav = new ModelAndView("JSP/STUDENT/timetable");

        mav.addObject("timetable", timetableService.getTimetableForDivision(student.getDivision()));
        return mav;
    }

}
