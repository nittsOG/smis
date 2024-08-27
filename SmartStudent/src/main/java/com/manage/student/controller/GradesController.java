package com.manage.student.controller;

import com.manage.student.entities.SemesterResults;
import com.manage.student.entities.SemesterSummary;
import com.manage.student.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class GradesController {

    @Autowired
    private GradesService gradesService;

    @GetMapping("/student/results")
    public ModelAndView getGradesResults(HttpSession session) {
    	
    	Long studentId = (Long) session.getAttribute("studentId");
         if (studentId == null) {
             return new ModelAndView("redirect:/student/login");
         }
    	
    	ModelAndView mav=new ModelAndView("JSP/STUDENT/grades-results");
        // Fetching semester-wise detailed grades
        List<SemesterResults> results = gradesService.getResultsByStudentId(studentId);
        
        // Fetching GPA and summary for each semester
        List<SemesterSummary> summaries = gradesService.getSummariesByStudentId(studentId);
        
        mav.addObject("summaries", summaries);
        mav.addObject("results", results);
        
        return mav;  // Redirecting to grades-results.jsp
    }
}
