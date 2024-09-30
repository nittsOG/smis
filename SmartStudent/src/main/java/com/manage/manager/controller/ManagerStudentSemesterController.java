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

import com.manage.home.entities.Semester;
import com.manage.manager.service.Manager_FeeService;
import com.manage.manager.service.Manager_SemesterService;
import com.manage.manager.service.Manager_StudentSemesterService;
import com.manage.manager.service.Manager_StudentService;
import com.manage.student.entities.Fee;
import com.manage.student.entities.Student;
import com.manage.student.entities.StudentSemester;

@Controller
@RequestMapping("/manager/student-semesters")
public class ManagerStudentSemesterController {

    private final Manager_StudentSemesterService managerStudentSemesterService;
    private final Manager_StudentService manager_StudentService;
    private final Manager_SemesterService manager_SemesterService;
    private final Manager_FeeService manager_FeeService;

    @Autowired
    public ManagerStudentSemesterController(
            @Qualifier("managerStudentSemesterServiceImpl") Manager_StudentSemesterService managerStudentSemesterService,
            @Qualifier("managerStudentServiceImpl") Manager_StudentService manager_StudentService,
            @Qualifier("managerSemesterServiceImpl") Manager_SemesterService manager_SemesterService,
            @Qualifier("managerFeeServiceImpl") Manager_FeeService manager_FeeService) {
        this.managerStudentSemesterService = managerStudentSemesterService;
        this.manager_StudentService = manager_StudentService;
        this.manager_SemesterService = manager_SemesterService;
        this.manager_FeeService = manager_FeeService;
    }

    @GetMapping
    public ModelAndView listStudentSemesters(@RequestParam(value = "studentId", required = false) Long studentId,
                                             HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<StudentSemester> studentSemesters;
        if (studentId != null) {
            studentSemesters = managerStudentSemesterService.getStudentSemestersByStudentId(studentId);
        } else {
            studentSemesters = managerStudentSemesterService.getAllStudentSemesters();
        }

        List<Student> students = manager_StudentService.getAllStudents();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-semesters");
        mav.addObject("studentSemesters", studentSemesters);
        mav.addObject("students", students);
        mav.addObject("selectedStudentId", studentId);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showStudentSemesterDetails(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        StudentSemester studentSemester = managerStudentSemesterService.getStudentSemesterById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-semester-details");
        mav.addObject("studentSemester", studentSemester);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditStudentSemesterForm(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        StudentSemester studentSemester = managerStudentSemesterService.getStudentSemesterById(id);
        List<Student> students = manager_StudentService.getAllStudents();
        List<Semester> semesters = manager_SemesterService.getAllSemesters();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-semester-edit");
        mav.addObject("studentSemester", studentSemester);
        mav.addObject("students", students);
        mav.addObject("semesters", semesters);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateStudentSemester(@PathVariable Long id,
                                        @ModelAttribute("studentSemester") StudentSemester studentSemester,
                                        @RequestParam("semesterId") Long semesterId, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        StudentSemester existingStudentSemester = managerStudentSemesterService.getStudentSemesterById(id);
        existingStudentSemester.setStudent(studentSemester.getStudent());
        Semester semester = manager_SemesterService.getSemesterById(semesterId);
        existingStudentSemester.setSemester(semester);

        managerStudentSemesterService.updateStudentSemester(existingStudentSemester);
        return "redirect:/manager/student-semesters";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudentSemester(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        managerStudentSemesterService.deleteStudentSemester(id);
        return "redirect:/manager/student-semesters";
    }

    @GetMapping("/new")
    public ModelAndView showNewStudentSemesterForm(HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<Student> students = manager_StudentService.getAllStudents();
        List<Semester> semesters = manager_SemesterService.getAllSemesters();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-semester-new");
        mav.addObject("studentSemester", new StudentSemester());
        mav.addObject("students", students);
        mav.addObject("semesters", semesters);
        return mav;
    }

    @PostMapping("/new")
    public String saveStudentSemester(@ModelAttribute("studentSemester") StudentSemester studentSemester,
                                      @RequestParam("semesterId") Long semesterId, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        Semester semester = manager_SemesterService.getSemesterById(semesterId);
        studentSemester.setSemester(semester);

        managerStudentSemesterService.saveStudentSemester(studentSemester);

        Fee fee = new Fee();
        fee.setStudentSemester(studentSemester);

        Long feeId = manager_FeeService.saveFeeAndReturnId(fee);
        studentSemester.setFee(manager_FeeService.getFeeById(feeId));

        managerStudentSemesterService.updateStudentSemester(studentSemester);

        return "redirect:/manager/student-semesters";
    }
}
