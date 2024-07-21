package com.manage.admin.controller;

import com.manage.admin.service.Admin_AttendanceService;
import com.manage.home.entities.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/attendances")
public class AdminAttendanceController {

    private final Admin_AttendanceService adminAttendanceService;

    @Autowired
    public AdminAttendanceController(@Qualifier("adminAttendanceServiceImpl") Admin_AttendanceService adminAttendanceService) {
        this.adminAttendanceService = adminAttendanceService;
    }

    @GetMapping
    public ModelAndView listAttendances(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Attendance> attendances = adminAttendanceService.getAllAttendances();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-attendances");
        mav.addObject("attendances", attendances);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showAttendanceDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Attendance attendance = adminAttendanceService.getAttendanceById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-attendance-details");
        mav.addObject("attendance", attendance);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditAttendanceForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Attendance attendance = adminAttendanceService.getAttendanceById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-attendance-edit");
        mav.addObject("attendance", attendance);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateAttendance(@PathVariable Long id, @ModelAttribute("attendance") Attendance attendance, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminAttendanceService.updateAttendance(attendance);
        return "redirect:/admin/attendances/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteAttendance(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminAttendanceService.deleteAttendance(id);
        return "redirect:/admin/attendances";
    }

    @GetMapping("/new")
    public ModelAndView showNewAttendanceForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-attendance-new");
        mav.addObject("attendance", new Attendance());
        return mav;
    }

    @PostMapping("/new")
    public String saveAttendance(@ModelAttribute("attendance") Attendance attendance, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminAttendanceService.saveAttendance(attendance);
        return "redirect:/admin/attendances";
    }
}
