package com.manage.faculty.service;

import com.manage.faculty.dao.Faculty_FacultySubjectDAO;
import com.manage.faculty.entities.FacultySubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("facultyFacultySubjectServiceImpl")
public class Faculty_FacultySubjectServiceImpl implements Faculty_FacultySubjectService {

    private final Faculty_FacultySubjectDAO facultyFacultySubjectDAO;

    @Autowired
    public Faculty_FacultySubjectServiceImpl(@Qualifier("facultyFacultySubjectDAOImpl") Faculty_FacultySubjectDAO facultyFacultySubjectDAO) {
        this.facultyFacultySubjectDAO = facultyFacultySubjectDAO;
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public void updateFacultySubject(FacultySubject facultySubject) {
        facultyFacultySubjectDAO.updateFacultySubject(facultySubject);
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public FacultySubject getFacultySubjectById(Long facultySubjectId) {
        return facultyFacultySubjectDAO.getFacultySubjectById(facultySubjectId);
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public List<FacultySubject> getAllFacultySubjects() {
        return facultyFacultySubjectDAO.getAllFacultySubjects();
    }
}
