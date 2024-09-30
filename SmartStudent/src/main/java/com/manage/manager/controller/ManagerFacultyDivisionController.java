package com.manage.manager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manage.faculty.entities.Faculty;
import com.manage.faculty.entities.FacultyDivision;
import com.manage.home.entities.Division;
import com.manage.manager.service.Manager_DivisionService;
import com.manage.manager.service.Manager_FacultyDivisionService;
import com.manage.manager.service.Manager_FacultyService;

@Controller
@RequestMapping("/manager/facultyDivisions")
public class ManagerFacultyDivisionController {

    private final Manager_FacultyDivisionService managerFacultyDivisionService;
    private final Manager_DivisionService manager_DivisionService;
    private final Manager_FacultyService facultyService;

    @Autowired
    public ManagerFacultyDivisionController(@Qualifier("managerFacultyDivisionServiceImpl") Manager_FacultyDivisionService managerFacultyDivisionService,
                                            @Qualifier("managerDivisionServiceImpl") Manager_DivisionService manager_DivisionService,
                                            @Qualifier("managerFacultyServiceImpl")Manager_FacultyService facultyService) {
        this.managerFacultyDivisionService = managerFacultyDivisionService;
        this.manager_DivisionService = manager_DivisionService;
		this.facultyService = facultyService;
    }

    @GetMapping
    public ModelAndView listFacultyDivisions(@RequestParam(value = "facultyId", required = false) Long facultyId, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        List<FacultyDivision> facultyDivisions;

        if (facultyId != null) {
            facultyDivisions = managerFacultyDivisionService.getFacultyDivisionsByFacultyId(facultyId);
        } else {
            facultyDivisions = managerFacultyDivisionService.getAllFacultyDivisions();
        }

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-facultyDivisions");
        mav.addObject("facultyDivisions", facultyDivisions);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showFacultyDivisionDetails(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        FacultyDivision facultyDivision = managerFacultyDivisionService.getFacultyDivisionById(id);
        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-facultyDivision-details");
        mav.addObject("facultyDivision", facultyDivision);
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditFacultyDivisionForm(@PathVariable Long id, HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return new ModelAndView("redirect:/manager/login");
        }

        FacultyDivision facultyDivision = managerFacultyDivisionService.getFacultyDivisionById(id);
        List<Division> divisions = manager_DivisionService.getAllDivisions();

        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-facultyDivision-edit");
        mav.addObject("facultyDivision", facultyDivision);
        mav.addObject("divisions", divisions);
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String updateFacultyDivision(@PathVariable Long id,
                                        @RequestParam("faculty.facultyId") Long facultyId,
                                        @RequestParam("division.divisionId") Long divisionId,
                                        @RequestParam(value = "isFr", required = false) boolean isFr,
                                        HttpSession session) {
        Long managerId = (Long) session.getAttribute("managerId");
        if (managerId == null) {
            return "redirect:/manager/login";
        }

        // Fetch the existing FacultyDivision entity
        FacultyDivision facultyDivision = managerFacultyDivisionService.getFacultyDivisionById(id);

        // Update the faculty division's fields with request parameters
        Faculty faculty = facultyService.getFacultyById(facultyId);
        Division division = manager_DivisionService.getDivisionById(divisionId);
        
        facultyDivision.setFaculty(faculty);
        facultyDivision.setDivision(division);
        facultyDivision.setFr(isFr);  // `isFr` will be `false` if unchecked

        // Update the faculty division
        managerFacultyDivisionService.updateFacultyDivision(facultyDivision);

        return "redirect:/manager/facultyDivisions/{id}";
    }


//    @GetMapping("/{id}/delete")
//    public String deleteFacultyDivision(@PathVariable Long id, HttpSession session) {
//        Long managerId = (Long) session.getAttribute("managerId");
//        if (managerId == null) {
//            return "redirect:/manager/login";
//        }
//
//        managerFacultyDivisionService.deleteFacultyDivision(id);
//        return "redirect:/manager/facultyDivisions";
//    }
//
//    @GetMapping("/new")
//    public ModelAndView showNewFacultyDivisionForm(HttpSession session) {
//        Long managerId = (Long) session.getAttribute("managerId");
//        if (managerId == null) {
//            return new ModelAndView("redirect:/manager/login");
//        }
//
//        List<Division> divisions = manager_DivisionService.getAllDivisions();
//        ModelAndView mav = new ModelAndView("JSP/MANAGER/manager-facultyDivision-new");
//        mav.addObject("facultyDivision", new FacultyDivision());
//        mav.addObject("divisions", divisions);
//        return mav;
//    }
//
//    @PostMapping("/new")
//    public String saveFacultyDivision(@ModelAttribute("facultyDivision") FacultyDivision facultyDivision, HttpSession session) {
//        Long managerId = (Long) session.getAttribute("managerId");
//        if (managerId == null) {
//            return "redirect:/manager/login";
//        }
//
//        managerFacultyDivisionService.saveFacultyDivision(facultyDivision);
//        return "redirect:/manager/facultyDivisions";
//    }
}
