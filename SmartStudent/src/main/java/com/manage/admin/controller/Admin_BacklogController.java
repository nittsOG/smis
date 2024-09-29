package com.manage.admin.controller;

import com.manage.admin.service.Admin_BacklogService;
import com.manage.student.entities.Backlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/backlogs")
public class Admin_BacklogController {

    private final Admin_BacklogService adminBacklogService;

    @Autowired
    public Admin_BacklogController(@Qualifier("adminBacklogServiceImpl") Admin_BacklogService adminBacklogService) {
        this.adminBacklogService = adminBacklogService;
    }

    @GetMapping
    public ModelAndView listBacklogs(@RequestParam(value = "studentId", required = false) Long studentId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Backlog> backlogs;
        if (studentId != null) {
            backlogs = adminBacklogService.getBacklogsByStudentId(studentId);
        } else {
            backlogs = adminBacklogService.getAllBacklogs();
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-backlogs");
        mav.addObject("backlogs", backlogs);
        mav.addObject("studentId", studentId);  // Pass the filter parameter back to the view
        return mav;
    }


    @GetMapping("/{studentId}/{subjectCode}/{semester}")
    public ModelAndView showBacklogDetails(@PathVariable Long studentId,
                                           @PathVariable String subjectCode,
                                           @PathVariable Integer semester,
                                           HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Backlog backlog = adminBacklogService.getBacklogById(studentId, subjectCode, semester);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-backlog-details");
        mav.addObject("backlog", backlog);
        return mav;
    }

    @GetMapping("/{studentId}/{subjectCode}/{semester}/edit")
    public ModelAndView showEditBacklogForm(@PathVariable Long studentId,
                                            @PathVariable String subjectCode,
                                            @PathVariable Integer semester,
                                            HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Backlog backlog = adminBacklogService.getBacklogById(studentId, subjectCode, semester);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-backlog-edit");
        mav.addObject("backlog", backlog);
        return mav;
    }

    @PostMapping("/{studentId}/{subjectCode}/{semester}/edit")
    public String updateBacklog(@PathVariable Long studentId,
                                @PathVariable String subjectCode,
                                @PathVariable Integer semester,
                                @ModelAttribute("backlog") Backlog backlog,
                                HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminBacklogService.updateBacklog(backlog);
        return "redirect:/admin/backlogs";
    }

    @GetMapping("/{studentId}/{subjectCode}/{semester}/delete")
    public String deleteBacklog(@PathVariable Long studentId,
                                @PathVariable String subjectCode,
                                @PathVariable Integer semester,
                                HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminBacklogService.deleteBacklog(studentId, subjectCode, semester);
        return "redirect:/admin/backlogs";
    }

    @GetMapping("/new")
    public ModelAndView showNewBacklogForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-backlog-new");
        mav.addObject("backlog", new Backlog());
        return mav;
    }

    @PostMapping("/new")
    public String saveBacklog(@ModelAttribute("backlog") Backlog backlog, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminBacklogService.saveBacklog(backlog);
        return "redirect:/admin/backlogs";
    }
}
