package com.manage.admin.controller;

import com.manage.admin.service.Admin_TimetableService;
import com.manage.home.entities.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/timetable")
public class AdminTimetableController {

    private final Admin_TimetableService timetableService;

    @Autowired
    public AdminTimetableController(Admin_TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping("/list")
    public String listTimetables(Model model) {
        List<Timetable> timetables = timetableService.getAllTimetables();
        model.addAttribute("timetables", timetables);
        return "JSP/ADMIN/timetablelist";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Timetable timetable = new Timetable();
        model.addAttribute("timetable", timetable);
        return "JSP/ADMIN/timetable-form";
    }

    @PostMapping("/saveTimetable")
    public String saveTimetable(@ModelAttribute("timetable") Timetable timetable) {
        timetableService.saveTimetable(timetable);
        return "redirect:/JSP/ADMIN/timetablelist";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("timetableId") Long id, Model model) {
        Timetable timetable = timetableService.getTimetableById(id);
        model.addAttribute("timetable", timetable);
        return "JSP/ADMIN/timetable-form";
    }

    @GetMapping("/delete")
    public String deleteTimetable(@RequestParam("timetableId") Long id) {
        Timetable timetable = timetableService.getTimetableById(id);
        timetableService.deleteTimetable(timetable);
        return "redirect:/JSP/ADMIN/timetablelist";
    }
}
