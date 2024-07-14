package com.manage.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.faculty.dao.Faculty_SubjectDAO;
import com.manage.home.entities.Subject;

@Service
@Transactional("facultyTransactionManager")
public class FacultySubjectServiceImpl implements FacultySubjectService {

    private final Faculty_SubjectDAO facultySubjectDAO;

    @Autowired
    public FacultySubjectServiceImpl(@Qualifier("facultySubjectDAOImpl") Faculty_SubjectDAO facultySubjectDAO) {
        this.facultySubjectDAO = facultySubjectDAO;
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        return facultySubjectDAO.getSubjectById(subjectId);
    }

    @Override
    public void saveSubject(Subject subject) {
        facultySubjectDAO.saveSubject(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        facultySubjectDAO.updateSubject(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        facultySubjectDAO.deleteSubject(subject);
    }
}
