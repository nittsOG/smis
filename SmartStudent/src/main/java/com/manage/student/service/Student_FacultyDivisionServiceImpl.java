package com.manage.student.service;

import com.manage.student.dao.Student_FacultyDivisionDAO;
import com.manage.faculty.entities.FacultyDivision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("studentFacultyDivisionServiceImpl")
public class Student_FacultyDivisionServiceImpl implements Student_FacultyDivisionService {

    private final Student_FacultyDivisionDAO studentFacultyDivisionDAO;

    @Autowired
    public Student_FacultyDivisionServiceImpl(@Qualifier("studentFacultyDivisionDAOImpl") Student_FacultyDivisionDAO studentFacultyDivisionDAO) {
        this.studentFacultyDivisionDAO = studentFacultyDivisionDAO;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public FacultyDivision getFacultyDivisionById(Long facultyDivisionId) {
        return studentFacultyDivisionDAO.getFacultyDivisionById(facultyDivisionId);
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public List<FacultyDivision> getAllFacultyDivisions() {
        return studentFacultyDivisionDAO.getAllFacultyDivisions();
    }
}
