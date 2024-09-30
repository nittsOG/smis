package com.manage.manager.controller;

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
import com.manage.admin.service.Admin_DivisionService;
import com.manage.admin.service.Admin_FacultyService;
import com.manage.admin.service.Admin_SubjectService;
import com.manage.admin.service.Admin_TimetableService;
import com.manage.faculty.entities.Faculty;
import com.manage.home.entities.Division;
import com.manage.home.entities.Subject;
import com.manage.home.entities.Timetable;

@Controller
@RequestMapping("/manager/timetables")
public class ManagerTimetableController {

    private final Admin_TimetableService adminTimetableService;
    private final Admin_SubjectService adminSubjectService;
    private final Admin_FacultyService adminFacultyService;
    private final Admin_DivisionService adminDivisionService;

    @Autowired
    public ManagerTimetableController(
            @Qualifier("adminTimetableServiceImpl") Admin_TimetableService adminTimetableService,
            @Qualifier("adminSubjectServiceImpl") Admin_SubjectService adminSubjectService,
            @Qualifier("adminFacultyServiceImpl") Admin_FacultyService adminFacultyService,
            @Qualifier("adminDivisionServiceImpl") Admin_DivisionService adminDivisionService) {
        this.adminTimetableService = adminTimetableService;
        this.adminSubjectService = adminSubjectService;
        this.adminFacultyService = adminFacultyService;
        this.adminDivisionService = adminDivisionService;
    }

    @GetMapping
    public ModelAndView listTimetables(@RequestParam(value = "subjectId", required = false) Long subjectId,
                                       @RequestParam(value = "facultyId", required = false) Long facultyId,
                                       @RequestParam(value = "divisionId", required = false) Long divisionId,
                                       HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<Timetable> timetables;
        if (subjectId != null || facultyId != null || divisionId != null) {
            timetables = adminTimetableService.getFilteredTimetables(subjectId, facultyId, divisionId);
        } else {
            timetables = adminTimetableService.getAllTimetables();
        }

        List<Subject> subjects = adminSubjectService.getAllSubjects();
        List<Faculty> faculties = adminFacultyService.getAllFaculties();
        List<Division> divisions = adminDivisionService.getAllDivisions();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-timetables");
        mav.addObject("timetables", timetables);
        mav.addObject("subjects", subjects);
        mav.addObject("faculties", faculties);
        mav.addObject("divisions", divisions);
        mav.addObject("selectedSubjectId", subjectId);
        mav.addObject("selectedFacultyId", facultyId);
        mav.addObject("selectedDivisionId", divisionId);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showTimetableDetails(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Timetable timetable = adminTimetableService.getTimetableById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-timetable-details");
        mav.addObject("timetable", timetable);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditTimetableForm(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        Timetable timetable = adminTimetableService.getTimetableById(id);
        List<Subject> subjects = adminSubjectService.getAllSubjects();
        List<Faculty> faculties = adminFacultyService.getAllFaculties();
        List<Division> divisions = adminDivisionService.getAllDivisions();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-timetable-edit");
        mav.addObject("timetable", timetable);
        mav.addObject("subjects", subjects);
        mav.addObject("faculties", faculties);
        mav.addObject("divisions", divisions);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateTimetable(@PathVariable Long id,
                                  @RequestParam("subjectId") Long subjectId,
                                  @RequestParam("facultyId") Long facultyId,
                                  @RequestParam("divisionId") Long divisionId,
                                  @RequestParam("dayOfWeek") String dayOfWeek,
                                  @RequestParam("startTime") String startTime,
                                  @RequestParam("endTime") String endTime,
                                  HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        Timetable timetable = adminTimetableService.getTimetableById(id);
        timetable.setDayOfWeek(dayOfWeek);
        timetable.setStartTime(startTime);
        timetable.setEndTime(endTime);

        Subject subject = adminSubjectService.getSubjectById(subjectId);
        Faculty faculty = adminFacultyService.getFacultyById(facultyId);
        Division division = adminDivisionService.getDivisionById(divisionId);

        timetable.setSubject(subject);
        timetable.setFaculty(faculty);
        timetable.setDivision(division);

        adminTimetableService.updateTimetable(timetable);
        return "redirect:/manager/timetables";
    }

    @GetMapping("/new")
    public ModelAndView showNewTimetableForm(HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<Subject> subjects = adminSubjectService.getAllSubjects();
        List<Faculty> faculties = adminFacultyService.getAllFaculties();
        List<Division> divisions = adminDivisionService.getAllDivisions();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-timetable-new");
        mav.addObject("subjects", subjects);
        mav.addObject("faculties", faculties);
        mav.addObject("divisions", divisions);
        return mav;
    }

    @PostMapping("/new")
    public String saveTimetable(@RequestParam("subjectId") Long subjectId,
                                @RequestParam("facultyId") Long facultyId,
                                @RequestParam("divisionId") Long divisionId,
                                @RequestParam("dayOfWeek") String dayOfWeek,
                                @RequestParam("startTime") String startTime,
                                @RequestParam("endTime") String endTime,
                                HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        Timetable timetable = new Timetable();
        timetable.setDayOfWeek(dayOfWeek);
        timetable.setStartTime(startTime);
        timetable.setEndTime(endTime);

        Subject subject = adminSubjectService.getSubjectById(subjectId);
        Faculty faculty = adminFacultyService.getFacultyById(facultyId);
        Division division = adminDivisionService.getDivisionById(divisionId);

        timetable.setSubject(subject);
        timetable.setFaculty(faculty);
        timetable.setDivision(division);

        adminTimetableService.saveTimetable(timetable);
        return "redirect:/manager/timetables";
    }

    @GetMapping("/{id}/delete")
    public String deleteTimetable(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        adminTimetableService.deleteTimetable(id);
        return "redirect:/manager/timetables";
    }
}
