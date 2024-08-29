package com.manage.student.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.student.entities.StudentSemester;
import com.manage.student.service.StudentAttendanceService;
import com.manage.student.service.StudentSemesterService;

@Controller
public class StudentAttendanceController {

    private final StudentAttendanceService attendanceService;
    private final StudentSemesterService studentSemesterService;

    @Autowired
    public StudentAttendanceController(@Qualifier("studentAttendanceServiceImpl") StudentAttendanceService attendanceService,
                                       @Qualifier("studentSemesterServiceImpl") StudentSemesterService studentSemesterService) {
        this.attendanceService = attendanceService;
        this.studentSemesterService = studentSemesterService;
    }

    @GetMapping("/student/attendance")
    public ModelAndView getAttendanceSummary(@RequestParam(value = "semesterId", required = false) Long semesterId , HttpSession session) {
        ModelAndView mav = new ModelAndView("JSP/STUDENT/attendance-summary");

        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId == null) {
            return new ModelAndView("redirect:/student/login");
        }
        
        // Get the list of semesters for the student
        List<StudentSemester> semesters = studentSemesterService.getSemestersByStudentId(studentId);
        mav.addObject("semesters", semesters);

        // Get the attendance summary for the selected semester  
        if (semesterId != null) {
            Map<String, Map<String, Object>> attendanceSummary = attendanceService.getAttendanceSummary(studentId, semesterId);
            mav.addObject("attendanceSummary", attendanceSummary);
            mav.addObject("selectedSemesterId", semesterId);
            
        }


        return mav;
    }
}
