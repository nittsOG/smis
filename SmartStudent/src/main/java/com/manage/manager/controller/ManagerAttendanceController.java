package com.manage.manager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.manager.service.Manager_AttendanceService;
import com.manage.home.entities.Attendance;
import com.manage.home.entities.AttendanceStatus;

@Controller
@RequestMapping("/manager/attendances")
public class ManagerAttendanceController {

    private final Manager_AttendanceService managerAttendanceService;

    @Autowired
    public ManagerAttendanceController(
            @Qualifier("managerAttendanceServiceImpl") Manager_AttendanceService managerAttendanceService) {
        this.managerAttendanceService = managerAttendanceService;
    }

    // List attendances with filters
    @GetMapping
    public ModelAndView listAttendances(@RequestParam(required = false) Long studentId,
            @RequestParam(required = false) Long divisionId, @RequestParam(required = false) Long subjectId,
            @RequestParam(required = false) String date, HttpSession session) {

        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Date parsedDate = null;

        if (date != null && !date.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                parsedDate = dateFormat.parse(date);
            } catch (ParseException e) {
                ModelAndView modelAndView = new ModelAndView("/JSP/MANAGER/manager-attendances");
                modelAndView.addObject("error", "Invalid date format. Please use 'yyyy-MM-dd'.");
                return modelAndView;
            }
        }

        List<Attendance> attendances = managerAttendanceService.getFilteredAttendances(studentId, divisionId, subjectId,
                parsedDate);

        ModelAndView modelAndView = new ModelAndView("/JSP/MANAGER/manager-attendances");
        modelAndView.addObject("attendances", attendances);

        return modelAndView;
    }

    // Get attendance by ID
    @GetMapping("/{id}")
    public ModelAndView getAttendanceById(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Attendance attendance = managerAttendanceService.getAttendanceById(id);
        ModelAndView modelAndView = new ModelAndView("/JSP/MANAGER/manager-attendance-details");
        modelAndView.addObject("attendance", attendance);

        return modelAndView;
    }

    // Show Edit Attendance Form
    @GetMapping("/{id}/edit")
    public ModelAndView showEditAttendanceForm(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Attendance attendance = managerAttendanceService.getAttendanceById(id);
        ModelAndView modelAndView = new ModelAndView("/JSP/MANAGER/manager-attendance-edit");
        modelAndView.addObject("attendance", attendance);

        return modelAndView;
    }

    // Edit attendance
    @PostMapping("/{id}/edit")
    public String updateAttendance(@PathVariable Long id, @RequestParam("status") AttendanceStatus status,
            HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        Attendance attendance = managerAttendanceService.getAttendanceById(id);
        attendance.setStatus(status);
        managerAttendanceService.updateAttendance(attendance);

        return "redirect:/manager/attendances/" + id;
    }

    // Delete attendance
    @GetMapping("/{id}/delete")
    public String deleteAttendance(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        managerAttendanceService.deleteAttendance(id);
        return "redirect:/manager/attendances";
    }
}
