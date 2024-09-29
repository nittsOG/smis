package com.manage.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.admin.dao.Admin_SubjectDAO;
import com.manage.home.entities.Subject;

@Service
@Qualifier("adminSubjectServiceImpl")
@Transactional(transactionManager = "adminTransactionManager")
public class Admin_SubjectServiceImpl implements Admin_SubjectService {

    private final Admin_SubjectDAO adminSubjectDAO;

    @Autowired
    public Admin_SubjectServiceImpl(@Qualifier("adminSubjectDAOImpl") Admin_SubjectDAO adminSubjectDAO) {
        this.adminSubjectDAO = adminSubjectDAO;
    }

    @Override
    public void saveSubject(Subject subject) {
        adminSubjectDAO.saveSubject(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        adminSubjectDAO.updateSubject(subject);
    }

    @Override
    public void deleteSubject(Long subjectId) {
        adminSubjectDAO.deleteSubject(subjectId);
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        Subject subject = adminSubjectDAO.getSubjectById(subjectId);
        initializeSubject(subject);
        return subject;
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = adminSubjectDAO.getAllSubjects();
        subjects.forEach(this::initializeSubject);
        return subjects;
    }
    
    @Override
    public List<Subject> getSubjectsByCourse(Long courseId) {
        List<Subject> subjects = adminSubjectDAO.getSubjectsByCourse(courseId);
        subjects.forEach(this::initializeSubject);  // Ensure lazy loading is handled
        return subjects;
    }


    private void initializeSubject(Subject subject) {
        if (subject != null && subject.getCourse() != null) {
            subject.getCourse().getName();
        }
    }
}
