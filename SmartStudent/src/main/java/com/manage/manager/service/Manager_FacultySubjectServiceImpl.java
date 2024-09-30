package com.manage.manager.service;

import com.manage.faculty.entities.FacultySubject;
import com.manage.manager.dao.Manager_FacultySubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerFacultySubjectServiceImpl")
public class Manager_FacultySubjectServiceImpl implements Manager_FacultySubjectService {

    private final Manager_FacultySubjectDAO managerFacultySubjectDAO;

    @Autowired
    public Manager_FacultySubjectServiceImpl(
            @Qualifier("managerFacultySubjectDAOImpl") Manager_FacultySubjectDAO managerFacultySubjectDAO) {
        this.managerFacultySubjectDAO = managerFacultySubjectDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveFacultySubject(FacultySubject facultySubject) {
        managerFacultySubjectDAO.saveFacultySubject(facultySubject);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateFacultySubject(FacultySubject facultySubject) {
        managerFacultySubjectDAO.updateFacultySubject(facultySubject);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteFacultySubject(Long facultySubjectId) {
        managerFacultySubjectDAO.deleteFacultySubject(facultySubjectId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public FacultySubject getFacultySubjectById(Long facultySubjectId) {
        return managerFacultySubjectDAO.getFacultySubjectById(facultySubjectId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<FacultySubject> getAllFacultySubjects() {
        return managerFacultySubjectDAO.getAllFacultySubjects();
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<FacultySubject> getFacultySubjectsByFacultyId(Long facultyId) {
        return managerFacultySubjectDAO.getFacultySubjectsByFacultyId(facultyId);
    }
}
