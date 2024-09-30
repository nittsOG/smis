package com.manage.manager.service;

import com.manage.faculty.entities.FacultyDivision;
import com.manage.manager.dao.Manager_FacultyDivisionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerFacultyDivisionServiceImpl")
public class Manager_FacultyDivisionServiceImpl implements Manager_FacultyDivisionService {

    private final Manager_FacultyDivisionDAO managerFacultyDivisionDAO;

    @Autowired
    public Manager_FacultyDivisionServiceImpl(
            @Qualifier("managerFacultyDivisionDAOImpl") Manager_FacultyDivisionDAO managerFacultyDivisionDAO) {
        this.managerFacultyDivisionDAO = managerFacultyDivisionDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveFacultyDivision(FacultyDivision facultyDivision) {
        managerFacultyDivisionDAO.saveFacultyDivision(facultyDivision);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateFacultyDivision(FacultyDivision facultyDivision) {
        managerFacultyDivisionDAO.updateFacultyDivision(facultyDivision);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteFacultyDivision(Long facultyDivisionId) {
        managerFacultyDivisionDAO.deleteFacultyDivision(facultyDivisionId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public FacultyDivision getFacultyDivisionById(Long facultyDivisionId) {
        return managerFacultyDivisionDAO.getFacultyDivisionById(facultyDivisionId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<FacultyDivision> getAllFacultyDivisions() {
        return managerFacultyDivisionDAO.getAllFacultyDivisions();
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<FacultyDivision> getFacultyDivisionsByFacultyId(Long facultyId) {
        return managerFacultyDivisionDAO.getFacultyDivisionsByFacultyId(facultyId);
    }
}
