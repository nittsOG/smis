package com.manage.faculty.controller;

import java.util.Base64;
import javax.servlet.http.HttpSession;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.manage.faculty.entities.Faculty;
import com.manage.faculty.entities.FacultyAddress;
import com.manage.faculty.service.FacultyService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    
    private FacultyService facultyService;
    
    @Autowired
    public FacultyController(@Qualifier("facultyServiceImpl") FacultyService facultyService) {
        super();
        this.facultyService = facultyService;
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(HttpSession session) {
        Long id = (Long) session.getAttribute("facultyId");
        if (id == null) {
            return new ModelAndView("redirect:/faculty/login");
        }
        ModelAndView mav = new ModelAndView("JSP/FACULTY/faculty-dashboard");
        Faculty faculty = facultyService.getFacultyById(id);
        mav.addObject("faculty", faculty);
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public ModelAndView showProfile(HttpSession session) {
        Long id = (Long) session.getAttribute("facultyId");
        if (id == null) {
            return new ModelAndView("redirect:/faculty/login");
        }
        
        Faculty faculty = facultyService.getFacultyById(id);
        String photoBase64 = null;
        if (faculty.getPhoto() != null) {
            photoBase64 = Base64.getEncoder().encodeToString(faculty.getPhoto());
        }

        ModelAndView mav = new ModelAndView("JSP/FACULTY/faculty-profile");
        mav.addObject("faculty", faculty);
        mav.addObject("photoBase64", photoBase64);
        return mav;
    }

    @GetMapping("/profile/edit")
    public ModelAndView editProfile(HttpSession session) {
        Long id = (Long) session.getAttribute("facultyId");
        if (id == null) {
            return new ModelAndView("redirect:/faculty/login");
        }

        Faculty faculty = facultyService.getFacultyById(id);
        Hibernate.initialize(faculty.getFacultyAddress());

        ModelAndView mav = new ModelAndView("JSP/FACULTY/faculty-profile-edit");
        mav.addObject("faculty", faculty);
        return mav;
    }

    @PostMapping("/profile/update")
    public ModelAndView updateProfile(
            @RequestParam("username") String username, 
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("street") String street,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("country") String country,
            @RequestParam("zipCode") String zipCode,
            HttpSession session) {
        
        Long id = (Long) session.getAttribute("facultyId");
        if (id == null) {
            return new ModelAndView("redirect:/faculty/login");
        }

        // Get faculty entity and update its fields
        Faculty faculty = facultyService.getFacultyById(id);
        faculty.setUsername(username);
        faculty.setEmail(email);
        faculty.setPhone(phone);

        // Get the faculty's address and update its fields
        FacultyAddress address = faculty.getFacultyAddress();
        if (address != null) {
            address.setStreet(street);
            address.setCity(city);
            address.setState(state);
            address.setCountry(country);
            address.setZipCode(zipCode);
        } else {
            // If no address exists, create a new one and set it to the faculty
            address = new FacultyAddress();
            address.setStreet(street);
            address.setCity(city);
            address.setState(state);
            address.setCountry(country);
            address.setZipCode(zipCode);
            faculty.setFacultyAddress(address);
        }

        // Save the updated faculty and address data
        facultyService.updateFaculty(faculty);

        // Redirect to the profile page with a success message
        ModelAndView mav = new ModelAndView("redirect:/faculty/profile");
        mav.addObject("message", "Profile updated successfully!");
        return mav;
    }
}
