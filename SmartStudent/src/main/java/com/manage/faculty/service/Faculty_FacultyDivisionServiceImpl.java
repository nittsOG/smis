package com.manage.faculty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.dao.Faculty_FacultyDivisionDAO;
import com.manage.faculty.entities.FacultyDivision;
import com.manage.home.entities.Division;

@Service
@Qualifier("facultyFacultyDivisionServiceImpl")
public class Faculty_FacultyDivisionServiceImpl implements Faculty_FacultyDivisionService {

    private final Faculty_FacultyDivisionDAO facultyFacultyDivisionDAO;

    @Autowired
    public Faculty_FacultyDivisionServiceImpl(@Qualifier("facultyFacultyDivisionDAOImpl") Faculty_FacultyDivisionDAO facultyFacultyDivisionDAO) {
        this.facultyFacultyDivisionDAO = facultyFacultyDivisionDAO;
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public void updateFacultyDivision(FacultyDivision facultyDivision) {
        facultyFacultyDivisionDAO.updateFacultyDivision(facultyDivision);
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public FacultyDivision getFacultyDivisionById(Long facultyDivisionId) {
        return facultyFacultyDivisionDAO.getFacultyDivisionById(facultyDivisionId);
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public List<FacultyDivision> getAllFacultyDivisions() {
        return facultyFacultyDivisionDAO.getAllFacultyDivisions();
    }
    
    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public List<Division> getAllFacultyDivisionsbyAcultyId(Long facultyId) {
        return facultyFacultyDivisionDAO.getAllFacultyDivisions(facultyId);
    }
}
