package com.manage.admin.controller;

import com.manage.admin.service.Admin_SubjectService;
import com.manage.home.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/subject")
public class AdminSubjectController {

    private final Admin_SubjectService subjectService;

    @Autowired
    public AdminSubjectController(@Qualifier("adminSubjectServiceImpl")Admin_SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/list")
    public String listSubjects(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "JSP/ADMIN/subjectlist";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "JSP/ADMIN/subject-form";
    }

    @PostMapping("/saveSubject")
    public String saveSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.saveSubject(subject);
        return "redirect:/JSP/ADMIN/subjectlist";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("subjectId") Long id, Model model) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "JSP/ADMIN/subject-form";
    }

    @GetMapping("/delete")
    public String deleteSubject(@RequestParam("subjectId") Long id) {
        subjectService.deleteSubject(id);
        return "redirect:/JSP/ADMIN/subjectlist";
    }
}
