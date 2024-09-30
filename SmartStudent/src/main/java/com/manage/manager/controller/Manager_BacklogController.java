package com.manage.manager.controller;

import com.manage.manager.service.Manager_BacklogService;
import com.manage.student.entities.Backlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/manager/backlogs")
public class Manager_BacklogController {

    private final Manager_BacklogService managerBacklogService;

    @Autowired
    public Manager_BacklogController(@Qualifier("managerBacklogServiceImpl") Manager_BacklogService managerBacklogService) {
        this.managerBacklogService = managerBacklogService;
    }

    @GetMapping
    public ModelAndView listBacklogs(@RequestParam(value = "studentId", required = false) Long studentId, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<Backlog> backlogs;
        if (studentId != null) {
            backlogs = managerBacklogService.getBacklogsByStudentId(studentId);
        } else {
            backlogs = managerBacklogService.getAllBacklogs();
        }

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-backlogs");
        mav.addObject("backlogs", backlogs);
        mav.addObject("studentId", studentId);
        return mav;
    }

    @GetMapping("/{studentId}/{subjectCode}/{semester}")
    public ModelAndView showBacklogDetails(@PathVariable Long studentId,
                                           @PathVariable String subjectCode,
                                           @PathVariable Integer semester,
                                           HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Backlog backlog = managerBacklogService.getBacklogById(studentId, subjectCode, semester);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-backlog-details");
        mav.addObject("backlog", backlog);
        return mav;
    }

    @GetMapping("/{studentId}/{subjectCode}/{semester}/edit")
    public ModelAndView showEditBacklogForm(@PathVariable Long studentId,
                                            @PathVariable String subjectCode,
                                            @PathVariable Integer semester,
                                            HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Backlog backlog = managerBacklogService.getBacklogById(studentId, subjectCode, semester);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-backlog-edit");
        mav.addObject("backlog", backlog);
        return mav;
    }

    @PostMapping("/{studentId}/{subjectCode}/{semester}/edit")
    public String updateBacklog(@PathVariable Long studentId,
                                @PathVariable String subjectCode,
                                @PathVariable Integer semester,
                                @ModelAttribute("backlog") Backlog backlog,
                                HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        managerBacklogService.updateBacklog(backlog);
        return "redirect:/manager/backlogs";
    }

    @GetMapping("/{studentId}/{subjectCode}/{semester}/delete")
    public String deleteBacklog(@PathVariable Long studentId,
                                @PathVariable String subjectCode,
                                @PathVariable Integer semester,
                                HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        managerBacklogService.deleteBacklog(studentId, subjectCode, semester);
        return "redirect:/manager/backlogs";
    }

    @GetMapping("/new")
    public ModelAndView showNewBacklogForm(HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-backlog-new");
        mav.addObject("backlog", new Backlog());
        return mav;
    }

    @PostMapping("/new")
    public String saveBacklog(@ModelAttribute("backlog") Backlog backlog, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        managerBacklogService.saveBacklog(backlog);
        return "redirect:/manager/backlogs";
    }
}
