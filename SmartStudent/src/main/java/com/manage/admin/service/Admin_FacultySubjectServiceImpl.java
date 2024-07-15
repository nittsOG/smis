package com.manage.admin.service;

import com.manage.faculty.entities.FacultySubject;
import com.manage.admin.dao.Admin_FacultySubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminFacultySubjectServiceImpl")
public class Admin_FacultySubjectServiceImpl implements Admin_FacultySubjectService {

    private final Admin_FacultySubjectDAO adminFacultySubjectDAO;

    @Autowired
    public Admin_FacultySubjectServiceImpl(@Qualifier("adminFacultySubjectDAOImpl") Admin_FacultySubjectDAO adminFacultySubjectDAO) {
        this.adminFacultySubjectDAO = adminFacultySubjectDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveFacultySubject(FacultySubject facultySubject) {
        adminFacultySubjectDAO.saveFacultySubject(facultySubject);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateFacultySubject(FacultySubject facultySubject) {
        adminFacultySubjectDAO.updateFacultySubject(facultySubject);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteFacultySubject(Long facultySubjectId) {
        adminFacultySubjectDAO.deleteFacultySubject(facultySubjectId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public FacultySubject getFacultySubjectById(Long facultySubjectId) {
        return adminFacultySubjectDAO.getFacultySubjectById(facultySubjectId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<FacultySubject> getAllFacultySubjects() {
        return adminFacultySubjectDAO.getAllFacultySubjects();
    }
}
