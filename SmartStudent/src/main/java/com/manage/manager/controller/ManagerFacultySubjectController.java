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

import com.manage.faculty.entities.Faculty;
import com.manage.faculty.entities.FacultySubject;
import com.manage.home.entities.Subject;
import com.manage.manager.service.Manager_FacultyService;
import com.manage.manager.service.Manager_FacultySubjectService;
import com.manage.manager.service.Manager_SubjectService;

@Controller
@RequestMapping("/manager/facultySubjects")
public class ManagerFacultySubjectController {

    private final Manager_FacultySubjectService managerFacultySubjectService;
    private final Manager_SubjectService managerSubjectService;
    private final Manager_FacultyService managerFacultyService;

    @Autowired
    public ManagerFacultySubjectController(
            @Qualifier("managerFacultySubjectServiceImpl") Manager_FacultySubjectService managerFacultySubjectService,
            @Qualifier("managerSubjectServiceImpl") Manager_SubjectService managerSubjectService,
            @Qualifier("managerFacultyServiceImpl") Manager_FacultyService managerFacultyService) {
        this.managerFacultySubjectService = managerFacultySubjectService;
        this.managerSubjectService = managerSubjectService;
        this.managerFacultyService = managerFacultyService;
    }

    @GetMapping
    public ModelAndView listFacultySubjects(@RequestParam(value = "facultyId", required = false) Long facultyId,
            HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<FacultySubject> facultySubjects;

        if (facultyId != null) {
            facultySubjects = managerFacultySubjectService.getFacultySubjectsByFacultyId(facultyId);
        } else {
            facultySubjects = managerFacultySubjectService.getAllFacultySubjects();
        }

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-facultySubjects");
        mav.addObject("facultySubjects", facultySubjects);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showFacultySubjectDetails(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        FacultySubject facultySubject = managerFacultySubjectService.getFacultySubjectById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-facultySubject-details");
        mav.addObject("facultySubject", facultySubject);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditFacultySubjectForm(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        FacultySubject facultySubject = managerFacultySubjectService.getFacultySubjectById(id);
        List<Subject> subjects = managerSubjectService.getAllSubjects(); // Fetch list of subjects

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-facultySubject-edit");
        mav.addObject("facultySubject", facultySubject);
        mav.addObject("subjects", subjects); // Pass the list of subjects to the view
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateFacultySubject(@PathVariable Long id, @RequestParam("subjectId") Long subjectId,
            HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        FacultySubject facultySubject = managerFacultySubjectService.getFacultySubjectById(id);
        Subject subject = managerSubjectService.getSubjectById(subjectId);

        facultySubject.setSubject(subject);

        managerFacultySubjectService.updateFacultySubject(facultySubject);
        return "redirect:/manager/facultySubjects/{id}";
    }

    @GetMapping("/{id}/delete")
    public String deleteFacultySubject(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        managerFacultySubjectService.deleteFacultySubject(id);
        return "redirect:/manager/facultySubjects";
    }

    @GetMapping("/new")
    public ModelAndView showNewFacultySubjectForm(HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<Subject> subjects = managerSubjectService.getAllSubjects(); // Fetch list of subjects
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-facultySubject-new");
        mav.addObject("facultySubject", new FacultySubject());
        mav.addObject("subjects", subjects); // Pass the list of subjects to the view
        return mav;
    }

    @PostMapping("/new")
    public String saveFacultySubject(@RequestParam("facultyId") Long facultyId,
            @RequestParam("subjectId") Long subjectId, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        FacultySubject facultySubject = new FacultySubject();
        Faculty faculty = managerFacultyService.getFacultyById(facultyId);
        Subject subject = managerSubjectService.getSubjectById(subjectId);

        facultySubject.setFaculty(faculty);
        facultySubject.setSubject(subject);

        managerFacultySubjectService.saveFacultySubject(facultySubject);
        return "redirect:/manager/facultySubjects";
    }
}
