package com.manage.admin.controller;

import com.manage.admin.service.Admin_SessionService;
import com.manage.home.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/sessions")
public class AdminSessionController {

    private final Admin_SessionService adminSessionService;

    @Autowired
    public AdminSessionController(@Qualifier("adminSessionServiceImpl") Admin_SessionService adminSessionService) {
        this.adminSessionService = adminSessionService;
    }

    @GetMapping
    public ModelAndView listSessions(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Session> sessions = adminSessionService.getAllSessions();
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-sessions");
        mav.addObject("sessions", sessions);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showSessionDetails(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Session sessionDetail = adminSessionService.getSessionById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-session-details");
        mav.addObject("session", sessionDetail);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditSessionForm(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Session sessionDetail = adminSessionService.getSessionById(id);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-session-edit");
        mav.addObject("session", sessionDetail);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateSession(@PathVariable Long id, @ModelAttribute("session") Session session, HttpSession httpSession) {
        Long adminId = (Long) httpSession.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSessionService.updateSession(session);
        return "redirect:/admin/sessions/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteSession(@PathVariable Long id, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSessionService.deleteSession(id);
        return "redirect:/admin/sessions";
    }

    @GetMapping("/new")
    public ModelAndView showNewSessionForm(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-session-new");
        mav.addObject("session", new Session());
        return mav;
    }

    @PostMapping("/new")
    public String saveSession(@ModelAttribute("session") Session session, HttpSession httpSession) {
        Long adminId = (Long) httpSession.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminSessionService.saveSession(session);
        return "redirect:/admin/sessions";
    }
}
