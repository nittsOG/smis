package com.manage.manager.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.common.EncodingUtils;
import com.manage.home.entities.Department;
import com.manage.home.entities.Division;
import com.manage.manager.service.Manager_DepartmentService;
import com.manage.manager.service.Manager_DivisionService;
import com.manage.manager.service.Manager_StudentAddressService;
import com.manage.manager.service.Manager_StudentService;
import com.manage.student.entities.Student;
import com.manage.student.entities.StudentAddress;

@Controller
@RequestMapping("/manager")
public class ManagerStudentController {

	private final Manager_StudentService managerStudentService;
	private final Manager_StudentAddressService managerStudentAddressService;
	private final Manager_DivisionService managerDivisionService;
	private final Manager_DepartmentService managerDepartmentService;

	@Autowired
	public ManagerStudentController(
			@Qualifier("managerStudentServiceImpl") Manager_StudentService managerStudentService,
			@Qualifier("managerStudentAddressServiceImpl") Manager_StudentAddressService managerStudentAddressService,
			@Qualifier("managerDivisionServiceImpl") Manager_DivisionService managerDivisionService,
			@Qualifier("managerDepartmentServiceImpl") Manager_DepartmentService managerDepartmentService) {
		this.managerStudentService = managerStudentService;
		this.managerStudentAddressService = managerStudentAddressService;
		this.managerDivisionService = managerDivisionService;
		this.managerDepartmentService = managerDepartmentService;
	}

	@GetMapping("/students")
	public ModelAndView listStudents(@RequestParam(value = "studentId", required = false) Long studentId,
			@RequestParam(value = "division", required = false) String division, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId == null) {
			return new ModelAndView("redirect:/manager/login");
		}

		List<Student> students;
		if (studentId != null) {
			students = List.of(managerStudentService.getStudentById(studentId));
		} else if (division != null && !division.isEmpty()) {
			students = managerStudentService.getStudentsByDivision(division);
		} else {
			students = managerStudentService.getAllStudents();
		}

		students.forEach(student -> {
			if (student.getPhoto() != null) {
				student.setPhotoBase64(EncodingUtils.toBase64(student.getPhoto()));
			}
		});

		List<Division> divisions = managerDivisionService.getAllDivisions();
		List<Department> departments = managerDepartmentService.getAllDepartments();

		ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-students");
		mav.addObject("students", students);
		mav.addObject("divisions", divisions);
		mav.addObject("departments", departments);
		return mav;
	}

	@GetMapping("/students/{studentId}")
	public ModelAndView showStudentDetails(@PathVariable Long studentId, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId == null) {
			return new ModelAndView("redirect:/manager/login");
		}

		Student student = managerStudentService.getStudentById(studentId);
		if (student.getPhoto() != null) {
			student.setPhotoBase64(EncodingUtils.toBase64(student.getPhoto()));
		}

		ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-details");
		mav.addObject("student", student);
		return mav;
	}

	@GetMapping("/students/{studentId}/edit")
	public ModelAndView showEditStudentForm(@PathVariable Long studentId, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId == null) {
			return new ModelAndView("redirect:/manager/login");
		}

		Student student = managerStudentService.getStudentById(studentId);

		List<Division> divisions = managerDivisionService.getAllDivisions();
		List<Department> departments = managerDepartmentService.getAllDepartments();

		ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-student-edit");
		mav.addObject("student", student);
		mav.addObject("divisions", divisions);
		mav.addObject("departments", departments);
		return mav;
	}

	@PostMapping("/students/{studentId}/edit")
	public String updateStudent(@PathVariable Long studentId, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "email") String email,
			@RequestParam(value = "street") String street, @RequestParam(value = "city") String city,
			@RequestParam(value = "state") String state, @RequestParam(value = "country") String country,
			@RequestParam(value = "zipCode") String zipcode,
			@RequestParam(value = "division.divisionId") long divisionId,
			@RequestParam(value = "dateOfBirth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
			@RequestParam(value = "gender") String gender, @RequestParam(value = "contactNumber") String contactNumber,
			@RequestParam(value = "guardianName") String guardianName,
			@RequestParam(value = "guardianContact") String guardianContact,
			@RequestParam(value = "nationality") String nationality,
			@RequestParam(value = "enrollmentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enrollmentDate,
			@RequestParam(value = "status") String status,
			@RequestParam(value = "photoBase64", required = false) String photoBase64, HttpSession session)
			throws IOException {

		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId == null) {
			return "redirect:/manager/login";
		}

		try {
			Student student = managerStudentService.getStudentById(studentId);
			managerStudentService.updateStudent(student);

			student.setUsername(username);
			student.setPassword(password);
			student.setEmail(email);
			student.setDateOfBirth(dateOfBirth);
			student.setContactNumber(contactNumber);
			student.setGuardianName(guardianName);
			student.setGuardianContact(guardianContact);
			student.setNationality(nationality);
			student.setEnrollmentDate(enrollmentDate);
			student.setStatus(status);
			student.setGender(gender);

			if (photoBase64 != null && !photoBase64.isEmpty()) {
				byte[] photoBytes = Base64.getDecoder().decode(photoBase64.split(",")[1]);
				student.setPhoto(photoBytes);
			}

			Division division = managerDivisionService.getDivisionById(divisionId);
			student.setDivision(division);

			if (student.getAddress() == null) {
				StudentAddress a = managerStudentAddressService.getStudentAddressByStudentId(studentId);
				if (a == null) {
					StudentAddress newaddress = new StudentAddress();
					managerStudentAddressService.saveStudentAddress(newaddress);
					newaddress.setStudent(student);
					newaddress.setStreet(street);
					newaddress.setCity(city);
					newaddress.setState(state);
					newaddress.setCountry(country);
					newaddress.setZipCode(zipcode);
					managerStudentAddressService.updateStudentAddress(newaddress);
					student.setAddress(newaddress);
					managerStudentService.updateStudent(student);
				}
				a.setStreet(street);
				a.setCity(city);
				a.setState(state);
				a.setCountry(country);
				a.setZipCode(zipcode);
				managerStudentAddressService.updateStudentAddress(a);
				student.setAddress(a);
				managerStudentService.updateStudent(student);
			} else {
				student.getAddress().setStreet(street);
				student.getAddress().setCity(city);
				student.getAddress().setState(state);
				student.getAddress().setCountry(country);
				student.getAddress().setZipCode(zipcode);
				managerStudentService.updateStudent(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/manager/students/" + studentId;
	}

//	@GetMapping("/students/add")
//	public ModelAndView AddStudent(HttpSession session) {
//		Long managerId = (Long) session.getAttribute("managerId");
//		if (managerId == null) {
//			return new ModelAndView("redirect:/manager/login");
//		}
//
//		try {
//			Student student = new Student();
//			student.setUsername("default");
//			student.setEmail("default");
//			student.setPassword("default");
//			managerStudentService.saveStudent(student);
//
//			StudentAddress address = new StudentAddress();
//			address.setCity("default");
//			address.setCountry("default");
//			address.setState("default");
//			address.setStreet("default");
//			address.setZipCode("default");
//			managerStudentAddressService.saveStudentAddress(address);
//			address.setStudent(student);
//			student.setAddress(address);
//			managerStudentService.updateStudent(student);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return new ModelAndView("redirect:/manager/students");
//	}

//	@PostMapping("/students/delete/{studentId}")
//	public String deleteStudent(@PathVariable Long studentId, HttpSession session) {
//		Long managerId = (Long) session.getAttribute("managerId");
//		if (managerId == null) {
//			return "redirect:/manager/login";
//		}
//
//		try {
//			Student student = managerStudentService.getStudentById(studentId);
//			if (student != null) {
//				managerStudentService.deleteStudent(student);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return "redirect:/manager/students";
//	}
}
