package com.manage.manager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.manager.service.Manager_StudentSemesterSubjectService;
import com.manage.manager.service.Manager_StudentSemesterService;
import com.manage.manager.service.Manager_SubjectService;
import com.manage.home.entities.Subject;
import com.manage.student.entities.StudentSemester;
import com.manage.student.entities.StudentSemesterSubject;

@Controller
@RequestMapping("/manager/student-semester-subjects")
public class ManagerStudentSemesterSubjectController {

    private final Manager_StudentSemesterSubjectService managerStudentSemesterSubjectService;
    private final Manager_StudentSemesterService managerStudentSemesterService;
    private final Manager_SubjectService managerSubjectService;

    @Autowired
    public ManagerStudentSemesterSubjectController(
            @Qualifier("managerStudentSemesterSubjectServiceImpl") Manager_StudentSemesterSubjectService managerStudentSemesterSubjectService,
            @Qualifier("managerStudentSemesterServiceImpl") Manager_StudentSemesterService managerStudentSemesterService,
            @Qualifier("managerSubjectServiceImpl") Manager_SubjectService managerSubjectService) {
        this.managerStudentSemesterSubjectService = managerStudentSemesterSubjectService;
        this.managerStudentSemesterService = managerStudentSemesterService;
        this.managerSubjectService = managerSubjectService;
    }

    @GetMapping
    public ModelAndView listStudentSemesterSubjects(HttpSession session,
            @RequestParam(value = "studentId", required = false) Long studentId) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<StudentSemesterSubject> studentSemesterSubjects;
        if (studentId != null) {
            studentSemesterSubjects = managerStudentSemesterSubjectService
                    .getStudentSemesterSubjectsByStudentId(studentId);
        } else {
            studentSemesterSubjects = managerStudentSemesterSubjectService.getAllStudentSemesterSubjects();
        }

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-semester-subjects");
        mav.addObject("studentSemesterSubjects", studentSemesterSubjects);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showStudentSemesterSubjectDetails(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        StudentSemesterSubject studentSemesterSubject = managerStudentSemesterSubjectService
                .getStudentSemesterSubjectById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-semester-subject-details");
        mav.addObject("studentSemesterSubject", studentSemesterSubject);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditStudentSemesterSubjectForm(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        StudentSemesterSubject studentSemesterSubject = managerStudentSemesterSubjectService
                .getStudentSemesterSubjectById(id);
        List<StudentSemester> studentSemesters = managerStudentSemesterService.getAllStudentSemesters();
        List<Subject> subjects = managerSubjectService.getAllSubjects();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-semester-subject-edit");
        mav.addObject("studentSemesterSubject", studentSemesterSubject);
        mav.addObject("studentSemesters", studentSemesters);
        mav.addObject("subjects", subjects);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateStudentSemesterSubject(@PathVariable Long id,
            @ModelAttribute("studentSemesterSubject") StudentSemesterSubject studentSemesterSubject,
            HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        // Ensure the ID is set correctly
        studentSemesterSubject.setStudentSemesterSubjectId(id);

        managerStudentSemesterSubjectService.updateStudentSemesterSubject(studentSemesterSubject);
        return "redirect:/manager/student-semester-subjects/" + id;
    }

//    @GetMapping("/{id}/delete")
//    public String deleteStudentSemesterSubject(@PathVariable Long id, HttpSession session) {
//        Long managerId = (Long) session.getAttribute("managerId");
//        if (managerId == null) {
//            return "redirect:/manager/login";
//        }
//
//        managerStudentSemesterSubjectService.deleteStudentSemesterSubject(id);
//        return "redirect:/manager/student-semester-subjects";
//    }
//
//    @GetMapping("/new")
//    public ModelAndView showNewStudentSemesterSubjectForm(HttpSession session) {
//        Long managerId = (Long) session.getAttribute("managerId");
//        if (managerId == null) {
//            return new ModelAndView("redirect:/manager/login");
//        }
//
//        List<StudentSemester> studentSemesters = managerStudentSemesterService.getAllStudentSemesters();
//        List<Subject> subjects = managerSubjectService.getAllSubjects();
//
//        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-semester-subject-new");
//        mav.addObject("studentSemesterSubject", new StudentSemesterSubject());
//        mav.addObject("studentSemesters", studentSemesters);
//        mav.addObject("subjects", subjects);
//        return mav;
//    }
//
//    @PostMapping("/new")
//    public String saveStudentSemesterSubject(
//            @ModelAttribute("studentSemesterSubject") StudentSemesterSubject studentSemesterSubject,
//            HttpSession session) {
//        Long managerId = (Long) session.getAttribute("managerId");
//        if (managerId == null) {
//            return "redirect:/manager/login";
//        }
//
//        managerStudentSemesterSubjectService.saveStudentSemesterSubject(studentSemesterSubject);
//        return "redirect:/manager/student-semester-subjects";
//    }
}
