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
import com.manage.admin.service.Admin_FacultyAddressService;
import com.manage.admin.service.Admin_FacultyService;
import com.manage.common.EncodingUtils;
import com.manage.faculty.entities.Faculty;
import com.manage.faculty.entities.FacultyAddress;
import com.manage.home.entities.Department;

@Controller
@RequestMapping("/admin")
public class AdminFacultyController {

	private final Admin_FacultyService adminFacultyService;
	private final Admin_DepartmentService adminDepartmentService;
	private final Admin_FacultyAddressService admin_FacultyAddressService;
	
	@Autowired
	public AdminFacultyController(@Qualifier("adminFacultyServiceImpl")Admin_FacultyService adminFacultyService,
			@Qualifier("adminDepartmentServiceImpl")Admin_DepartmentService adminDepartmentService, @Qualifier("adminFacultyAddressServiceImpl")Admin_FacultyAddressService admin_FacultyAddressService) {
		this.adminFacultyService = adminFacultyService;
		this.adminDepartmentService = adminDepartmentService;
		this.admin_FacultyAddressService = admin_FacultyAddressService;
	}
	
	@GetMapping("/faculty")
	public ModelAndView listFacultys(@RequestParam(value = "facultyId", required = false) Long facultyId,
			@RequestParam(value = "department", required = false) String department, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		List<Faculty> Faculties;
		if (facultyId != null) {
			Faculties = List.of(adminFacultyService.getFacultyById(facultyId));
		} else if (department != null && !department.isEmpty()) {
			Faculties = adminFacultyService.getFacultyByDepartment(department);
		} else {
			Faculties = adminFacultyService.getAllFaculties();
		}

		Faculties.forEach(Faculty -> {
			if (Faculty.getPhoto() != null) {
				Faculty.setPhotoBase64(EncodingUtils.toBase64(Faculty.getPhoto()));
			}
		});
		
		List<Department> departments = adminDepartmentService.getAllDepartments();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-faculty");
		mav.addObject("faculty", Faculties);
		mav.addObject("departments", departments);

		return mav;
	}
	
	@GetMapping("/faculty/{facultyId}")
	public ModelAndView showStudentDetails(@PathVariable Long facultyId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Faculty faculty = adminFacultyService.getFacultyById(facultyId);
		if (faculty.getPhoto() != null) {
			faculty.setPhotoBase64(EncodingUtils.toBase64(faculty.getPhoto()));
		}

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-faculty-details");
		mav.addObject("faculty", faculty);
		return mav;
	}
	
	@GetMapping("/faculty/{facultyId}/edit")
	public ModelAndView showEditStudentForm(@PathVariable Long facultyId, HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		Faculty faculty = adminFacultyService.getFacultyById(facultyId);

		List<Department> departments = adminDepartmentService.getAllDepartments();

		ModelAndView mav = new ModelAndView("JSP/ADMIN/admin-faculty-edit");
		mav.addObject("faculty", faculty);
		mav.addObject("departments", departments);
		return mav;
	}

	@PostMapping("/faculty/{facultyId}/edit")
	public String updateStudent(@PathVariable Long facultyId, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "email") String email,
			@RequestParam(value = "street") String street, @RequestParam(value = "city") String city,
			@RequestParam(value = "state") String state, @RequestParam(value = "country") String country,
			@RequestParam(value = "zipCode") String zipcode,
			@RequestParam(value = "department.departmentId") long departmentId,
			@RequestParam(value = "dateOfBirth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
			@RequestParam(value = "gender") String gender, @RequestParam(value = "contactNumber") String contactNumber,
			@RequestParam(value = "nationality") String nationality,
			@RequestParam(value = "position") String position,
			@RequestParam(value = "photoBase64", required = false) String photoBase64, HttpSession session)
			throws IOException {

		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return "redirect:/admin/login";
		}
		System.out.println("\n\n username: "+ username);
		// Fetch the existing student and address to ensure no data loss
		try {
			Faculty faculty = adminFacultyService.getFacultyById(facultyId);
//			adminStudentService.updateStudent(student);
//			System.out.println("\n\n\n 1 : " + address.getCity());
//
//			// Update student details
//			System.out.println("\n\n 2 : " + username + city);
			
			adminFacultyService.updateFaculty(faculty);
			faculty.setUsername(username);
			faculty.setPassword(password);
			faculty.setEmail(email);
			faculty.setDateOfBirth(dateOfBirth);
			faculty.setPhone(contactNumber);
			faculty.setNationality(nationality);
			faculty.setPosition(position);
			faculty.setGender(gender);
			
			// If a Base64-encoded photo is provided, decode it and set it to the student
			if (photoBase64 != null && !photoBase64.isEmpty()) {
				byte[] photoBytes = Base64.getDecoder().decode(photoBase64.split(",")[1]); // Skip the "data:image/..."
																							// part
				faculty.setPhoto(photoBytes);
			}

			// Update department
//			Division division = adminDivisionService.getDivisionById(divisionId);
			Department department = adminDepartmentService.getDepartmentById(departmentId);
			faculty.setDepartment(department);
			
			if(faculty.getFacultyAddress()==null) {  // if no student address
//				StudentAddress a= adminStudentAddressService.getStudentAddressByStudentId(studentId);
				FacultyAddress a= admin_FacultyAddressService.getFacultyAddressByFacultyId(facultyId);
				if(a==null) {
					// create new address
					FacultyAddress newaddress = new FacultyAddress();
					admin_FacultyAddressService.saveFacultyAddress(newaddress);
					newaddress.setFaculty(faculty);
					newaddress.setStreet(street);
					newaddress.setCity(city);
					newaddress.setState(state);
					newaddress.setCountry(country);
					newaddress.setZipCode(zipcode);
					admin_FacultyAddressService.updateFacultyAddress(newaddress);
					faculty.setFacultyAddress(newaddress);
					adminFacultyService.updateFaculty(faculty);
				}
				
				a.setStreet(street);
				a.setCity(city);
				a.setState(state);
				a.setCountry(country);
				a.setZipCode(zipcode);
				admin_FacultyAddressService.updateFacultyAddress(a);
				faculty.setFacultyAddress(a);
				adminFacultyService.updateFaculty(faculty);
			}
			
			// Update student address
			faculty.getFacultyAddress().setStreet(street);
			faculty.getFacultyAddress().setCity(city);
			faculty.getFacultyAddress().setState(state);
			faculty.getFacultyAddress().setCountry(country);
			faculty.getFacultyAddress().setZipCode(zipcode);
			
			adminFacultyService.updateFaculty(faculty);
			System.out.println("\n\n : " + faculty.getFacultyAddress().getCity());

		} catch (Exception e) {
			System.out.println(e);
		}

		Faculty s = adminFacultyService.getFacultyById(facultyId);
		System.out.println("\n\n" + s.getUsername() + s.getFacultyAddress().getCity());
		return "redirect:/admin/faculty/" + facultyId;
	}
	
	
	@GetMapping("/faculty/add")
	public ModelAndView AddStudent(HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if (adminId == null) {
			return new ModelAndView("redirect:/admin/login");
		}

		try {
			Faculty faculty=new Faculty();
			faculty.setUsername("default");
			faculty.setEmail("default");
			faculty.setPassword("default");
			faculty.setPhone("0000000000");
			faculty.setPosition("NoPosition");
			adminFacultyService.saveFaculty(faculty);
			
			FacultyAddress address = new FacultyAddress();
			address.setCity("default");
			address.setCountry("default");
			address.setState("default");
			address.setStreet("default");
			address.setZipCode("default");
			address.setFaculty(faculty);
			admin_FacultyAddressService.saveFacultyAddress(address);
			faculty.setFacultyAddress(address);
			adminFacultyService.updateFaculty(faculty);


			ModelAndView mav = new ModelAndView("redirect:/admin/faculty");
			return mav;
		} catch (Exception e) {
			ModelAndView mave = new ModelAndView("redirect:/admin/faculty");
			mave.addObject("error", "default already exist");
			System.out.println(e);
			return mave;
		}
	}
		
		@PostMapping("/faculty/delete/{facultyId}")
		public String deleteStudent(@PathVariable Long facultyId, HttpSession session) {
			Long adminId = (Long) session.getAttribute("adminId");

			// Ensure that an admin is logged in
			if (adminId == null) {
				return "redirect:/admin/login";
			}

			// Try to delete student and address
			try {
				// Delete the student
				adminFacultyService.deleteFacultyById(facultyId);
				// Delete associated address
				admin_FacultyAddressService.deleteFacultyAddressByFacultyId(facultyId);
			} catch (Exception e) {
				System.out.println("Error deleting student with ID " + facultyId);
				e.printStackTrace();
			}

			// Redirect to the list of students after deletion
			return "redirect:/admin/faculty";
		}
	
}
	
