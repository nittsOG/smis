package com.manage.admin.controller;

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

import com.manage.admin.service.Admin_DepartmentService;
import com.manage.admin.service.Admin_DivisionService;
import com.manage.admin.service.Admin_StudentAddressService;
import com.manage.admin.service.Admin_StudentService;
import com.manage.common.EncodingUtils;
import com.manage.home.entities.Department;
import com.manage.home.entities.Division;
import com.manage.student.entities.Student;
import com.manage.student.entities.StudentAddress;

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
			@RequestParam(value = "department", required = false) String department, HttpSession session) {
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

		// ****************
		Student s = adminStudentService.getStudentById((long) 49);
		System.out.println("/n/n" + s.getAddress().getCity());
		s.getAddress().setCity("notDefaault");
		adminStudentService.updateStudent(s);
		StudentAddress a = adminStudentAddressService.getStudentAddressByStudentId((long) 49);
		System.out.println("/n/n" + a.getCity());
		// ***********

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
//		StudentAddress studentAddress = adminStudentAddressService.getStudentAddressById(studentId);

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-details");
		mav.addObject("student", student);
//		mav.addObject("studentAddress", studentAddress);
		return mav;
	}

	@GetMapping("/students/{studentId}/edit")
	public ModelAndView showEditStudentForm(@PathVariable Long studentId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Student student = adminStudentService.getStudentById(studentId);
//		StudentAddress studentAddress = adminStudentAddressService.getStudentAddressById(studentId); // Fetch student

		// System.out.println("\n\n\n\n"+studentAddress.getCity());

		List<Division> divisions = adminDivisionService.getAllDivisions();
		List<Department> departments = adminDepartmentService.getAllDepartments();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-edit");
		mav.addObject("student", student);
//		mav.addObject("address", studentAddress); // Add address to the model
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

		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		// Fetch the existing student and address to ensure no data loss
		try {
			Student student = adminStudentService.getStudentById(studentId);
			adminStudentService.updateStudent(student);
//			System.out.println("\n\n\n 1 : " + address.getCity());
//
//			// Update student details
//			System.out.println("\n\n 2 : " + username + city);
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
			
			// If a Base64-encoded photo is provided, decode it and set it to the student
			if (photoBase64 != null && !photoBase64.isEmpty()) {
				byte[] photoBytes = Base64.getDecoder().decode(photoBase64.split(",")[1]); // Skip the "data:image/..."
																							// part
				student.setPhoto(photoBytes);
			}

			// Update division
			Division division = adminDivisionService.getDivisionById(divisionId);
			student.setDivision(division);
			
			if(student.getAddress()==null) {  // if no student address
				StudentAddress a= adminStudentAddressService.getStudentAddressByStudentId(studentId);
				if(a==null) {
					// create new address
					StudentAddress newaddress = new StudentAddress();
					adminStudentAddressService.saveStudentAddress(newaddress);
					newaddress.setStudent(student);
					newaddress.setStreet(street);
					newaddress.setCity(city);
					newaddress.setState(state);
					newaddress.setCountry(country);
					newaddress.setZipCode(zipcode);
					adminStudentAddressService.updateStudentAddress(newaddress);
					student.setAddress(newaddress);
					adminStudentService.updateStudent(student);
				}
				
				a.setStreet(street);
				a.setCity(city);
				a.setState(state);
				a.setCountry(country);
				a.setZipCode(zipcode);
				adminStudentAddressService.updateStudentAddress(a);
				student.setAddress(a);
				adminStudentService.updateStudent(student);
			}
			
			// Update student address
			student.getAddress().setStreet(street);
			student.getAddress().setCity(city);
			student.getAddress().setState(state);
			student.getAddress().setCountry(country);
			student.getAddress().setZipCode(zipcode);
			
			adminStudentService.updateStudent(student);
			System.out.println("\n\n : " + student.getAddress().getCity());

			// Save the updated student and address
//			
//			if (address.getStudent() != student) {
//				address.setStudent(student);
//				
//			}
////			adminStudentService.updateStudent(student);
//			
//			if (student.getAddress() != address) {
//				student.setAddress(address);
//				adminStudentService.updateStudent(student);
//			}
//			adminStudentAddressService.updateStudentAddress(address);

		} catch (Exception e) {
			System.out.println(e);
		}

		Student s = adminStudentService.getStudentById(studentId);
		System.out.println("\n\n" + s.getUsername() + s.getAddress().getCity());
		return "redirect:/admin/students/" + studentId;
	}

//**********************************

	// ADD New student
	@GetMapping("/students/add")
	public ModelAndView AddStudent(HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

//		Student student = adminStudentService.getStudentById(studentId);
		try {
			Student student = new Student();
			student.setUsername("default");
			student.setEmail("default");
			student.setPassword("default");

//			System.out.println("\n\n"+ student.getStudentId());
			adminStudentService.saveStudent(student);
//			System.out.println("\n\n"+ student.getStudentId());

			StudentAddress address = new StudentAddress();
			address.setCity("default");
			address.setCountry("default");
			address.setState("default");
			address.setStreet("default");
			address.setZipCode("default");
			address.setStudent(student);
			adminStudentAddressService.saveStudentAddress(address);
			student.setAddress(address);
			adminStudentService.updateStudent(student);

//			System.out.println("\n\n"+ student.getAddress().getCity());
//			System.out.println("\n\n"+ address.getCity());

			ModelAndView mav = new ModelAndView("redirect:/admin/students");
			return mav;
		} catch (Exception e) {
			ModelAndView mave = new ModelAndView("redirect:/admin/students");
			mave.addObject("error", "default already exist");
			return mave;
		}
	}

//***************************************

//	@GetMapping("/students/add")
//	public ModelAndView showAddStudentForm(HttpSession session) {
//		Long adminId = (Long) session.getAttribute("adminId");
//		if (adminId == null) {
//			return new ModelAndView("redirect:/admin/login");
//		}
//
//		List<Division> divisions = adminDivisionService.getAllDivisions();
//		List<Department> departments = adminDepartmentService.getAllDepartments();
//
//		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-student-add");
//		mav.addObject("divisions", divisions);
//		mav.addObject("departments", departments);
//		return mav;
//	}
//
//	@PostMapping("/students/add")
//	public String AddStudent(@RequestParam(value = "username") String username,
//			@RequestParam(value = "password") String password, @RequestParam(value = "email") String email,
//			@RequestParam(value = "street") String street, @RequestParam(value = "city") String city,
//			@RequestParam(value = "state") String state, @RequestParam(value = "country") String country,
//			@RequestParam(value = "zipCode") String zipcode, @RequestParam(value = "divisionId") long divisionId,
//			@RequestParam(value = "dateOfBirth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
//			@RequestParam(value = "gender") String gender, @RequestParam(value = "contactNumber") String contactNumber,
//			@RequestParam(value = "guardianName") String guardianName,
//			@RequestParam(value = "guardianContact") String guardianContact,
//			@RequestParam(value = "nationality") String nationality,
//			@RequestParam(value = "enrollmentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enrollmentDate,
//			@RequestParam(value = "status") String status,
//			@RequestParam(value = "photoBase64", required = false) String photoBase64, HttpSession session)
//			throws IOException {
//
//		if (session.getAttribute("adminId") == null) {
//			return "redirect:/admin/login";
//		}
//
//		// Fetch the existing student and address to ensure no data loss
//		Student student = new Student();
//		StudentAddress address = new StudentAddress();
//
//		// Update student details
//		student.setUsername(username);
//		student.setPassword(password);
//		student.setEmail(email);
//		student.setDateOfBirth(dateOfBirth);
//		student.setContactNumber(contactNumber);
//		student.setGuardianName(guardianName);
//		student.setGuardianContact(guardianContact);
//		student.setNationality(nationality);
//		student.setEnrollmentDate(enrollmentDate);
//		student.setStatus(status);
//		student.setGender(gender); 
//
//		// Update student address
//		address.setStreet(street);
//		address.setCity(city);
//		address.setState(state);
//		address.setCountry(country);
//		address.setZipCode(zipcode);
//
//		// If a Base64-encoded photo is provided, decode it and set it to the student
//		if (photoBase64 != null && !photoBase64.isEmpty()) {
//			byte[] photoBytes = Base64.getDecoder().decode(photoBase64.split(",")[1]); // Skip the "data:image/..." part
//			student.setPhoto(photoBytes);
//		}
//
//		// Update division
//		Division division = adminDivisionService.getDivisionById(divisionId);
//		student.setDivision(division);
//
//		// Save the updated student and address
//		adminStudentService.updateStudent(student);
//		adminStudentAddressService.updateStudentAddress(address);
//
//		try {
//			adminStudentService.createStudent(student);
//			adminStudentAddressService.createStudentAddress(address);
//			student.setAddress(adminStudentAddressService.getStudentAddressByStudentId(student.getStudentId()));
//			adminStudentAddressService.saveStudentAddress(address);
//			adminStudentService.saveStudent(student);
//
//		} catch (Exception e) {
//			System.out.println("\n\n Fail to create student..\n\n");
//			e.printStackTrace();
//		}
//
//		return "redirect:/admin/students/";
//	}

//*********************************
	@PostMapping("/students/delete/{studentId}")
	public String deleteStudent(@PathVariable Long studentId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");

		// Ensure that an admin is logged in
		if (adminId == null) {
			return "redirect:/admin/login";
		}

		// Try to delete student and address
		try {
			// Delete the student
			adminStudentService.deleteStudentById(studentId);
			// Delete associated address
			adminStudentAddressService.deleteStudentAddressByStudentId(studentId);
		} catch (Exception e) {
			System.out.println("Error deleting student with ID " + studentId);
			e.printStackTrace();
		}

		// Redirect to the list of students after deletion
		return "redirect:/admin/students";
	}

//*********************

	void Student_CheckAndUpdate(Student student, String name, String password, String email) {

		if (student.getUsername() != name) {
			student.setUsername(name);
		} else if (student.getPassword() != password) {
			student.setPassword(password);
		} else if (student.getEmail() != email) {
			student.setEmail(email);
		}

	}

	void Address_CheckeAndUpdate(StudentAddress address, String city, String state, String street, String country,
			String zipcode) {

		if (address.getStreet() != state) {
			address.setStreet(street);
		} else if (address.getCity() != city) {
			address.setCity(city);
		} else if (address.getState() != state) {
			address.setState(state);
		} else if (address.getCountry() != country) {
			address.setCountry(country);
		} else if (address.getZipCode() != zipcode) {
			address.setZipCode(zipcode);
		}
	}
}
