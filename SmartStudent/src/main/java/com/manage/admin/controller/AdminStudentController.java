package com.manage.admin.controller;

import com.manage.student.entities.Student;
import com.manage.student.entities.StudentAddress;
import com.manage.admin.service.Admin_StudentService;
import com.manage.admin.service.Admin_StudentAddressService;
import com.manage.common.EncodingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminStudentController {

    private final Admin_StudentService adminStudentService;
    private final Admin_StudentAddressService adminStudentAddressService;

    @Autowired
    public AdminStudentController(@Qualifier("adminStudentServiceImpl") Admin_StudentService adminStudentService,
                                  @Qualifier("adminStudentAddressServiceImpl") Admin_StudentAddressService adminStudentAddressService) {
        this.adminStudentService = adminStudentService;
        this.adminStudentAddressService = adminStudentAddressService;
    }

    @GetMapping("/students")
    public ModelAndView listStudents(HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Student> students = adminStudentService.getAllStudents();
        students.forEach(student -> {
            if (student.getPhoto() != null) {
                student.setPhotoBase64(EncodingUtils.toBase64(student.getPhoto()));
            }
        });
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-students");
        mav.addObject("students", students);
        return mav;
    }

    @GetMapping("/students/{studentId}")
    public ModelAndView showStudentDetails(@PathVariable Long studentId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Student student = adminStudentService.getStudentById(studentId);
        if (student.getPhoto() != null) {
            student.setPhotoBase64(EncodingUtils.toBase64(student.getPhoto()));
        }
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-details");
        mav.addObject("student", student);
        return mav;
    }

    @GetMapping("/students/{studentId}/edit")
    public ModelAndView showEditStudentForm(@PathVariable Long studentId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Student student = adminStudentService.getStudentById(studentId);
        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-edit");
        mav.addObject("student", student);
        return mav;
    }

    @PostMapping("/students/{studentId}/edit")
    public String updateStudent(@PathVariable Long studentId, @ModelAttribute("student") Student student,
                                @RequestParam(value = "photo", required = false) MultipartFile photo, HttpSession session) throws IOException {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        if (photo != null && !photo.isEmpty()) {
            student.setPhoto(photo.getBytes());
        }
        adminStudentService.updateStudent(student);
        return "redirect:/admin/students/{studentId}";
    }

    @GetMapping("/students/{studentId}/address")
    public ModelAndView showStudentAddress(@PathVariable Long studentId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Student student = adminStudentService.getStudentById(studentId);
        StudentAddress studentAddress = adminStudentAddressService.getStudentAddressById(studentId);

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-address");
        mav.addObject("student", student);
        mav.addObject("studentAddress", studentAddress);
        return mav;
    }

    @GetMapping("/students/{studentId}/address/edit")
    public ModelAndView showEditStudentAddressForm(@PathVariable Long studentId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Student student = adminStudentService.getStudentById(studentId);
        StudentAddress studentAddress = adminStudentAddressService.getStudentAddressById(studentId);

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-address-edit");
        mav.addObject("student", student);
        mav.addObject("studentAddress", studentAddress);
        return mav;
    }

    @PostMapping("/students/{studentId}/address/edit")
    public String updateStudentAddress(@PathVariable Long studentId, @ModelAttribute("studentAddress") StudentAddress studentAddress, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentAddressService.updateStudentAddress(studentAddress);
        return "redirect:/admin/students/{studentId}/address";
    }

    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable Long studentId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentService.deleteStudent(studentId);
        return "redirect:/admin/students";
    }
}
