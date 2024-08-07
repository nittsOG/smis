package com.manage.admin.service;

import com.manage.admin.dao.Admin_FacultyDAO;
import com.manage.faculty.entities.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("adminFacultyServiceImpl")
public class Admin_FacultyServiceImpl implements Admin_FacultyService {

    private final Admin_FacultyDAO adminFacultyDAO;

    @Autowired
    public Admin_FacultyServiceImpl(@Qualifier("adminFacultyDAOImpl") Admin_FacultyDAO adminFacultyDAO) {
        this.adminFacultyDAO = adminFacultyDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Faculty getFacultyById(Long facultyId) {
        return adminFacultyDAO.getFacultyById(facultyId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveFaculty(Faculty faculty) {
        adminFacultyDAO.saveFaculty(faculty);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateFaculty(Faculty faculty) {
        adminFacultyDAO.updateFaculty(faculty);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteFaculty(Faculty faculty) {
        adminFacultyDAO.deleteFaculty(faculty);
    }
}
