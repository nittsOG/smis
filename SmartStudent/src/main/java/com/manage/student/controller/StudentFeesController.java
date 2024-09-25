package com.manage.student.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.student.entities.Fee;
import com.manage.student.service.Student_FeeService;

@Controller
public class StudentFeesController {

    private final Student_FeeService feeService;

    @Autowired
    public StudentFeesController(@Qualifier("studentFeeServiceImpl") Student_FeeService feeService) {
        this.feeService = feeService;
    }

    @GetMapping("/student/fees")
    public ModelAndView showFees(HttpSession session) {
        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId == null) {
           // System.out.println("Student ID is null in the session");
            return new ModelAndView("redirect:/login");
        }
        
        List<Fee> fees = feeService.getAllFeesOfStudent(studentId);

//        if (fees == null || fees.isEmpty()) {
//           // System.out.println("No fees found for student ID: " + studentId);
//        }

        ModelAndView mav = new ModelAndView("JSP/STUDENT/student-fees");
        mav.addObject("fees", fees);
        return mav;
    }

}
