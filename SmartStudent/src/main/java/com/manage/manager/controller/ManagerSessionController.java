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

import com.manage.manager.service.Manager_DivisionService;
import com.manage.manager.service.Manager_SessionService;
import com.manage.manager.service.Manager_SubjectService;
import com.manage.home.entities.Division;
import com.manage.home.entities.Session;
import com.manage.home.entities.Subject;

@Controller
@RequestMapping("/manager/sessions")
public class ManagerSessionController {

    private final Manager_SessionService managerSessionService;
    private final Manager_SubjectService managerSubjectService;
    private final Manager_DivisionService managerDivisionService;

    @Autowired
    public ManagerSessionController(@Qualifier("managerSessionServiceImpl") Manager_SessionService managerSessionService,
                                    @Qualifier("managerSubjectServiceImpl") Manager_SubjectService managerSubjectService,
                                    @Qualifier("managerDivisionServiceImpl") Manager_DivisionService managerDivisionService) {
        this.managerSessionService = managerSessionService;
        this.managerSubjectService = managerSubjectService;
        this.managerDivisionService = managerDivisionService;
    }

    @GetMapping
    public ModelAndView listSessions(@RequestParam(value = "subjectId", required = false) Long subjectId, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<Session> sessions;
        if (subjectId != null) {
            sessions = managerSessionService.getSessionsBySubject(subjectId);
        } else {
            sessions = managerSessionService.getAllSessions();
        }

        List<Subject> subjects = managerSubjectService.getAllSubjects();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-sessions");
        mav.addObject("sessions", sessions);
        mav.addObject("subjects", subjects);
        mav.addObject("selectedSubjectId", subjectId);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showSessionDetails(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Session sessionDetail = managerSessionService.getSessionById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-session-details");
        mav.addObject("session", sessionDetail);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditSessionForm(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Session sessionDetail = managerSessionService.getSessionById(id);
        List<Subject> subjects = managerSubjectService.getAllSubjects();
        List<Division> divisions = managerDivisionService.getAllDivisions();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-session-edit");
        mav.addObject("session", sessionDetail);
        mav.addObject("subjects", subjects);
        mav.addObject("divisions", divisions);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateSession(@PathVariable Long id,
                                @RequestParam("sessionDate") String sessionDate,
                                @RequestParam("sessionType") String sessionType,
                                @RequestParam("startTime") String startTime,
                                @RequestParam("endTime") String endTime,
                                @RequestParam("subjectId") Long subjectId,
                                @RequestParam("divisionId") Long divisionId,
                                @RequestParam("facultyId") Long facultyId,
                                HttpSession httpSession) {
        Long managerId = (Long) httpSession.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        try {
            Date parsedSessionDate = dateFormat.parse(sessionDate);
            Date parsedStartTime = timeFormat.parse(startTime);
            Date parsedEndTime = timeFormat.parse(endTime);

            Session session = managerSessionService.getSessionById(id);
            session.setSessionDate(parsedSessionDate);
            session.setSessionType(sessionType);
            session.setStartTime(parsedStartTime);
            session.setEndTime(parsedEndTime);
            session.setDivision_Id(divisionId);
            session.setFaculty_Id(facultyId);

            Subject subject = managerSubjectService.getSubjectById(subjectId);
            session.setSubject(subject);

            managerSessionService.updateSession(session);

        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/manager/sessions/" + id + "/edit?error=Invalid date or time format";
        }

        return "redirect:/manager/sessions/" + id;
    }

    @GetMapping("/{id}/delete")
    public String deleteSession(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        managerSessionService.deleteSession(id);
        return "redirect:/manager/sessions";
    }

    @GetMapping("/new")
    public ModelAndView showNewSessionForm(HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<Subject> subjects = managerSubjectService.getAllSubjects();
        List<Division> divisions = managerDivisionService.getAllDivisions();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-session-new");
        mav.addObject("subjects", subjects);
        mav.addObject("divisions", divisions);
        return mav;
    }

    @PostMapping("/new")
    public String saveSession(@RequestParam("sessionDate") String sessionDate,
                              @RequestParam("sessionType") String sessionType,
                              @RequestParam("startTime") String startTime,
                              @RequestParam("endTime") String endTime,
                              @RequestParam("subjectId") Long subjectId,
                              @RequestParam("divisionId") Long divisionId,
                              @RequestParam("facultyId") Long facultyId,
                              HttpSession httpSession) {
        Long managerId = (Long) httpSession.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        try {
            Date parsedSessionDate = dateFormat.parse(sessionDate);
            Date parsedStartTime = timeFormat.parse(startTime);
            Date parsedEndTime = timeFormat.parse(endTime);

            Session session = new Session();
            session.setSessionDate(parsedSessionDate);
            session.setSessionType(sessionType);
            session.setStartTime(parsedStartTime);
            session.setEndTime(parsedEndTime);
            session.setDivision_Id(divisionId);
            session.setFaculty_Id(facultyId);

            Subject subject = managerSubjectService.getSubjectById(subjectId);
            session.setSubject(subject);

            managerSessionService.saveSession(session);

        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/manager/sessions/new?error=Invalid date or time format";
        }

        return "redirect:/manager/sessions";
    }
}
