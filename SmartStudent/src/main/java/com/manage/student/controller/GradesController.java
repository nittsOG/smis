package com.manage.student.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.student.entities.Backlog;
import com.manage.student.entities.SemesterResults;
import com.manage.student.entities.SemesterSummary;
import com.manage.student.service.GradesService;

@Controller
public class GradesController {
    
    private GradesService gradesService;
    
    @Autowired
    public GradesController(@Qualifier("studentGradesServiceImpl")GradesService gradesService) {
		this.gradesService = gradesService;
	}


    @GetMapping("/student/results")
    public ModelAndView getGradesResults(HttpSession session) {
        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId == null) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mav = new ModelAndView("JSP/STUDENT/grades-results");

        // Fetching semester-wise detailed grades
        List<SemesterResults> results = gradesService.getResultsByStudentId(studentId);

        // Fetching GPA and summary for each semester
        List<SemesterSummary> summaries = gradesService.getSummariesByStudentId(studentId);

        // Fetching backlog status
        List<Backlog> backlogs = gradesService.getBacklogsByStudentId(studentId);

        mav.addObject("results", results);
        mav.addObject("summaries", summaries);
        mav.addObject("backlog", backlogs);

        return mav;
    }
}
