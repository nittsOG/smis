package com.manage.admin.service;

import com.manage.admin.dao.Admin_FacultyDAO;
import com.manage.faculty.entities.Faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminFacultyServiceImpl")
public class Admin_FacultyServiceImpl implements Admin_FacultyService {

    private final Admin_FacultyDAO adminFacultyDAO;

    @Autowired
    public Admin_FacultyServiceImpl(@Qualifier("adminFacultyDAOImpl") Admin_FacultyDAO adminFacultyDAO) {
        this.adminFacultyDAO = adminFacultyDAO;
    }

    @Override
    @Transactional("adminTransactionManager")
    public void saveFaculty(Faculty faculty) {
        adminFacultyDAO.saveFaculty(faculty);
    }

    @Override
    @Transactional("adminTransactionManager")
    public void updateFaculty(Faculty faculty) {
        adminFacultyDAO.updateFaculty(faculty);
    }

    @Override
    @Transactional("adminTransactionManager")
    public void deleteFaculty(Faculty faculty) {
    	
//    	adminFacultyDAO.deleteFaculty(adminFacultyDAO.getFacultyById(facultyId));
        adminFacultyDAO.deleteFaculty(faculty);
    }

    @Override
    @Transactional("adminTransactionManager")
    public Faculty getFacultyById(Long facultyId) {
        Faculty faculty = adminFacultyDAO.getFacultyById(facultyId);
        // Initialize lazy property
        if (faculty != null && faculty.getDepartment() != null) {
            faculty.getDepartment().getName(); // Access to initialize
        }
        return faculty;
    }

    @Override
    @Transactional("adminTransactionManager")
    public List<Faculty> getAllFaculties() {
        List<Faculty> faculties = adminFacultyDAO.getAllFaculties();
        for (Faculty faculty : faculties) {
            // Initialize lazy property
            if (faculty.getDepartment() != null) {
                faculty.getDepartment().getName(); // Access to initialize
            }
        }
        return faculties;
    }
}
