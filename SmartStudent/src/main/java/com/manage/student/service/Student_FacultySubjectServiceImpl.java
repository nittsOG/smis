package com.manage.student.service;

import com.manage.student.dao.Student_FacultySubjectDAO;
import com.manage.faculty.entities.FacultySubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("studentFacultySubjectServiceImpl")
public class Student_FacultySubjectServiceImpl implements Student_FacultySubjectService {

    private final Student_FacultySubjectDAO studentFacultySubjectDAO;

    @Autowired
    public Student_FacultySubjectServiceImpl(@Qualifier("studentFacultySubjectDAOImpl") Student_FacultySubjectDAO studentFacultySubjectDAO) {
        this.studentFacultySubjectDAO = studentFacultySubjectDAO;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public FacultySubject getFacultySubjectById(Long facultySubjectId) {
        return studentFacultySubjectDAO.getFacultySubjectById(facultySubjectId);
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public List<FacultySubject> getAllFacultySubjects() {
        return studentFacultySubjectDAO.getAllFacultySubjects();
    }
}
