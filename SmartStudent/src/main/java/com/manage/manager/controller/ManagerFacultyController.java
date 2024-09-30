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

import com.manage.manager.service.Manager_DepartmentService;
import com.manage.manager.service.Manager_FacultyAddressService;
import com.manage.manager.service.Manager_FacultyService;
import com.manage.common.EncodingUtils;
import com.manage.faculty.entities.Faculty;
import com.manage.faculty.entities.FacultyAddress;
import com.manage.home.entities.Department;

@Controller
@RequestMapping("/manager")
public class ManagerFacultyController {

	private final Manager_FacultyService managerFacultyService;
	private final Manager_DepartmentService managerDepartmentService;
	private final Manager_FacultyAddressService manager_FacultyAddressService;
	
	@Autowired
	public ManagerFacultyController(@Qualifier("managerFacultyServiceImpl") Manager_FacultyService managerFacultyService,
			@Qualifier("managerDepartmentServiceImpl") Manager_DepartmentService managerDepartmentService, 
            @Qualifier("managerFacultyAddressServiceImpl") Manager_FacultyAddressService manager_FacultyAddressService) {
		this.managerFacultyService = managerFacultyService;
		this.managerDepartmentService = managerDepartmentService;
		this.manager_FacultyAddressService = manager_FacultyAddressService;
	}
	
	@GetMapping("/faculty")
	public ModelAndView listFacultys(@RequestParam(value = "facultyId", required = false) Long facultyId,
			@RequestParam(value = "department", required = false) String department, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId == null) {
			return new ModelAndView("redirect:/manager/login");
		}

		List<Faculty> Faculties;
		if (facultyId != null) {
			Faculties = List.of(managerFacultyService.getFacultyById(facultyId));
		} else if (department != null && !department.isEmpty()) {
			Faculties = managerFacultyService.getFacultyByDepartment(department);
		} else {
			Faculties = managerFacultyService.getAllFaculties();
		}

		Faculties.forEach(Faculty -> {
			if (Faculty.getPhoto() != null) {
				Faculty.setPhotoBase64(EncodingUtils.toBase64(Faculty.getPhoto()));
			}
		});
		
		List<Department> departments = managerDepartmentService.getAllDepartments();

		ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-faculty");
		mav.addObject("faculty", Faculties);
		mav.addObject("departments", departments);

		return mav;
	}
	
	@GetMapping("/faculty/{facultyId}")
	public ModelAndView showFacultyDetails(@PathVariable Long facultyId, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId == null) {
			return new ModelAndView("redirect:/manager/login");
		}

		Faculty faculty = managerFacultyService.getFacultyById(facultyId);
		if (faculty.getPhoto() != null) {
			faculty.setPhotoBase64(EncodingUtils.toBase64(faculty.getPhoto()));
		}

		ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-faculty-details");
		mav.addObject("faculty", faculty);
		return mav;
	}
	
	@GetMapping("/faculty/{facultyId}/edit")
	public ModelAndView showEditFacultyForm(@PathVariable Long facultyId, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId == null) {
			return new ModelAndView("redirect:/manager/login");
		}

		Faculty faculty = managerFacultyService.getFacultyById(facultyId);

		List<Department> departments = managerDepartmentService.getAllDepartments();

		ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-faculty-edit");
		mav.addObject("faculty", faculty);
		mav.addObject("departments", departments);
		return mav;
	}

	@PostMapping("/faculty/{facultyId}/edit")
	public String updateFaculty(@PathVariable Long facultyId, @RequestParam(value = "username") String username,
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

		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId == null) {
			return "redirect:/manager/login";
		}

		try {
			Faculty faculty = managerFacultyService.getFacultyById(facultyId);
			managerFacultyService.updateFaculty(faculty);
			faculty.setUsername(username);
			faculty.setPassword(password);
			faculty.setEmail(email);
			faculty.setDateOfBirth(dateOfBirth);
			faculty.setPhone(contactNumber);
			faculty.setNationality(nationality);
			faculty.setPosition(position);
			faculty.setGender(gender);
			
			if (photoBase64 != null && !photoBase64.isEmpty()) {
				byte[] photoBytes = Base64.getDecoder().decode(photoBase64.split(",")[1]);
				faculty.setPhoto(photoBytes);
			}

			Department department = managerDepartmentService.getDepartmentById(departmentId);
			faculty.setDepartment(department);
			
			if(faculty.getFacultyAddress()==null) {
				FacultyAddress a = manager_FacultyAddressService.getFacultyAddressByFacultyId(facultyId);
				if(a==null) {
					FacultyAddress newaddress = new FacultyAddress();
					manager_FacultyAddressService.saveFacultyAddress(newaddress);
					newaddress.setFaculty(faculty);
					newaddress.setStreet(street);
					newaddress.setCity(city);
					newaddress.setState(state);
					newaddress.setCountry(country);
					newaddress.setZipCode(zipcode);
					manager_FacultyAddressService.updateFacultyAddress(newaddress);
					faculty.setFacultyAddress(newaddress);
					managerFacultyService.updateFaculty(faculty);
				}
				
				a.setStreet(street);
				a.setCity(city);
				a.setState(state);
				a.setCountry(country);
				a.setZipCode(zipcode);
				manager_FacultyAddressService.updateFacultyAddress(a);
				faculty.setFacultyAddress(a);
				managerFacultyService.updateFaculty(faculty);
			}
			
			faculty.getFacultyAddress().setStreet(street);
			faculty.getFacultyAddress().setCity(city);
			faculty.getFacultyAddress().setState(state);
			faculty.getFacultyAddress().setCountry(country);
			faculty.getFacultyAddress().setZipCode(zipcode);
			
			managerFacultyService.updateFaculty(faculty);

		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:/manager/faculty/" + facultyId;
	}
	
//	@GetMapping("/faculty/add")
//	public ModelAndView addFaculty(HttpSession session) {
//		Long managerId = (Long) session.getAttribute("managerId");
//		if (managerId == null) {
//			return new ModelAndView("redirect:/manager/login");
//		}
//
//		try {
//			Faculty faculty = new Faculty();
//			faculty.setUsername("default");
//			faculty.setEmail("default");
//			faculty.setPassword("default");
//			faculty.setPhone("0000000000");
//			faculty.setPosition("NoPosition");
//			managerFacultyService.saveFaculty(faculty);
//			
//			FacultyAddress address = new FacultyAddress();
//			address.setCity("default");
//			address.setCountry("default");
//			address.setState("default");
//			address.setStreet("default");
//			address.setZipCode("default");
//			address.setFaculty(faculty);
//			manager_FacultyAddressService.saveFacultyAddress(address);
//			faculty.setFacultyAddress(address);
//			managerFacultyService.updateFaculty(faculty);
//
//			ModelAndView mav = new ModelAndView("redirect:/manager/faculty");
//			return mav;
//		} catch (Exception e) {
//			return new ModelAndView("redirect:/manager/faculty");
//		}
//	}

//	@GetMapping("/faculty/{facultyId}/delete")
//	public String deleteFaculty(@PathVariable Long facultyId, HttpSession session) {
//		Long managerId = (Long) session.getAttribute("managerId");
//		if (managerId == null) {
//			return "redirect:/manager/login";
//		}
//
//		try {
//			Faculty faculty = managerFacultyService.getFacultyById(facultyId);
//			if (faculty != null) {
//				managerFacultyService.deleteFacultyById(facultyId);
//			}
//		} catch (Exception e) {
//			return "redirect:/manager/faculty?error";
//		}
//
//		return "redirect:/manager/faculty";
//	}
}
