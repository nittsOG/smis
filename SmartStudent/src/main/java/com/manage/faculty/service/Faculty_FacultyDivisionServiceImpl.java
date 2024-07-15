package com.manage.faculty.service;

import com.manage.faculty.dao.Faculty_FacultyDivisionDAO;
import com.manage.faculty.entities.FacultyDivision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
