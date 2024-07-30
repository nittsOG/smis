package com.manage.admin.controller;

import com.manage.student.entities.Student;
import com.manage.student.entities.StudentAddress;
import com.manage.admin.service.Admin_StudentService;
import com.manage.admin.service.Admin_StudentAddressService;
import com.manage.admin.service.Admin_DepartmentService;
import com.manage.admin.service.Admin_DivisionService;
import com.manage.common.EncodingUtils;
import com.manage.home.entities.Division;
import com.manage.home.entities.Department;

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
    private final Admin_DivisionService adminDivisionService;
    private final Admin_DepartmentService adminDepartmentService;

    @Autowired
    public AdminStudentController(@Qualifier("adminStudentServiceImpl") Admin_StudentService adminStudentService,
                                  @Qualifier("adminStudentAddressServiceImpl") Admin_StudentAddressService adminStudentAddressService,
                                  @Qualifier("adminDivisionServiceImpl") Admin_DivisionService adminDivisionService,
                                  @Qualifier("adminDepartmentServiceImpl") Admin_DepartmentService adminDepartmentService) {
        this.adminStudentService = adminStudentService;
        this.adminStudentAddressService = adminStudentAddressService;
        this.adminDivisionService = adminDivisionService;
        this.adminDepartmentService = adminDepartmentService;
    }

    @GetMapping("/students")
    public ModelAndView listStudents(@RequestParam(value = "studentId", required = false) Long studentId,
                                     @RequestParam(value = "division", required = false) String division,
                                     @RequestParam(value = "department", required = false) String department,
                                     HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        List<Student> students;
        if (studentId != null) {
            students = List.of(adminStudentService.getStudentById(studentId));
        } else if (division != null && !division.isEmpty()) {
            students = adminStudentService.getStudentsByDivision(division);
        } else if (department != null && !department.isEmpty()) {
            students = adminStudentService.getStudentsByDepartment(department);
        } else {
            students = adminStudentService.getAllStudents();
        }

        students.forEach(student -> {
            if (student.getPhoto() != null) {
                student.setPhotoBase64(EncodingUtils.toBase64(student.getPhoto()));
            }
        });

        List<Division> divisions = adminDivisionService.getAllDivisions();
        List<Department> departments = adminDepartmentService.getAllDepartments();

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-students");
        mav.addObject("students", students);
        mav.addObject("divisions", divisions);
        mav.addObject("departments", departments);
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
        StudentAddress studentAddress = adminStudentAddressService.getStudentAddressById(studentId);

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-details");
        mav.addObject("student", student);
        mav.addObject("studentAddress", studentAddress);
        return mav;
    }

    @GetMapping("/students/{studentId}/edit")
    public ModelAndView showEditStudentForm(@PathVariable Long studentId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return new ModelAndView("redirect:/admin/login");
        }

        Student student = adminStudentService.getStudentById(studentId);
        StudentAddress studentAddress = adminStudentAddressService.getStudentAddressById(studentId);  // Fetch student address
        List<Division> divisions = adminDivisionService.getAllDivisions();
        List<Department> departments = adminDepartmentService.getAllDepartments();

        ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-edit");
        mav.addObject("student", student);
        mav.addObject("address", studentAddress);  // Add address to the model
        mav.addObject("divisions", divisions);
        mav.addObject("departments", departments);
        return mav;
    }

    @PostMapping("/students/{studentId}/edit")
    public String updateStudent(@PathVariable Long studentId,
                                @RequestParam(value = "username") String username,
                                @RequestParam(value = "password") String password,
                                @RequestParam(value = "email") String email,
                                @RequestParam(value = "address.street") String street,
                                @RequestParam(value = "address.city") String city,
                                @RequestParam(value = "address.state") String state,
                                @RequestParam(value = "address.country") String country,
                                @RequestParam(value = "address.zipCode") String zipcode,
                                @RequestParam(value = "division.divisionId") long divisionId,
                                @RequestParam(value = "photo", required = false) MultipartFile photo,
                                HttpSession session) throws IOException {

        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        Student student = adminStudentService.getStudentById(studentId);
        StudentAddress address = adminStudentAddressService.getStudentAddressById(studentId);

        if (!username.equals(student.getUsername())) {
            student.setUsername(username);
        }
        if (!password.equals(student.getPassword())) {
            student.setPassword(password);
        }
        if (!email.equals(student.getEmail())) {
            student.setEmail(email);
        }

        if (!street.equals(address.getStreet())) {
            address.setStreet(street);
        }
        if (!city.equals(address.getCity())) {
            address.setCity(city);
        }
        if (!state.equals(address.getState())) {
            address.setState(state);
        }
        if (!country.equals(address.getCountry())) {
            address.setCountry(country);
        }
        if (!zipcode.equals(address.getZipCode())) {
            address.setZipCode(zipcode);
        }

        if (photo != null && !photo.isEmpty()) {
            student.setPhoto(photo.getBytes());
        }

        // Fetch and set the new division
        Division division = adminDivisionService.getDivisionById(divisionId);
        student.setDivision(division);

        adminStudentService.updateStudent(student);
        adminStudentAddressService.updateStudentAddress(address); // Update address in a separate service call

        return "redirect:/admin/students/" + studentId;
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

    @PostMapping("/students/{studentId}/address")
    public String updateStudentAddress(@PathVariable Long studentId, @ModelAttribute("studentAddress") StudentAddress studentAddress, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentAddressService.updateStudentAddress(studentAddress);
        return "redirect:/admin/students/" + studentId;
    }

    @PostMapping("/students/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId, HttpSession session) {
        Long adminId = (Long) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/admin/login";
        }

        adminStudentService.deleteStudent(studentId);
        return "redirect:/admin/students";
    }
    
    void Student_CheckAndUpdate( Student student ,String name , String password , String email  ) {
    	
    	if(student.getUsername()!=name) {
    		student.setUsername(name);
    	}
    	else if(student.getPassword()!=password) {
    		student.setPassword(password);
    	}
    	else if(student.getEmail()!=email) {
    		student.setEmail(email);
    	}
    	
    	
    }
    
    void Address_CheckeAndUpdate(StudentAddress address ,String city,String state , String street,String country, String zipcode) {
    	
    	if(address.getStreet()!=state) {
    		address.setStreet(street);
    	}
    	else if(address.getCity()!=city) {
    		address.setCity(city);
    	}
    	else if(address.getState()!=state) {
    		address.setState(state);
    	}
    	else if(address.getCountry()!=country) {
    		address.setCountry(country);
    	}
    	else if(address.getZipCode()!=zipcode) {
    		address.setZipCode(zipcode);
    	}
    }
}
