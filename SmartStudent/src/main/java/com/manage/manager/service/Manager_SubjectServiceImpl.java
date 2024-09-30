package com.manage.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.manager.dao.Manager_SubjectDAO;
import com.manage.home.entities.Subject;

@Service
@Qualifier("managerSubjectServiceImpl")
@Transactional(transactionManager = "managerTransactionManager")
public class Manager_SubjectServiceImpl implements Manager_SubjectService {

    private final Manager_SubjectDAO managerSubjectDAO;

    @Autowired
    public Manager_SubjectServiceImpl(@Qualifier("managerSubjectDAOImpl") Manager_SubjectDAO managerSubjectDAO) {
        this.managerSubjectDAO = managerSubjectDAO;
    }

    @Override
    public void saveSubject(Subject subject) {
        managerSubjectDAO.saveSubject(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        managerSubjectDAO.updateSubject(subject);
    }

    @Override
    public void deleteSubject(Long subjectId) {
        managerSubjectDAO.deleteSubject(subjectId);
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        Subject subject = managerSubjectDAO.getSubjectById(subjectId);
        initializeSubject(subject);
        return subject;
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = managerSubjectDAO.getAllSubjects();
        subjects.forEach(this::initializeSubject);
        return subjects;
    }

    @Override
    public List<Subject> getSubjectsByCourse(Long courseId) {
        List<Subject> subjects = managerSubjectDAO.getSubjectsByCourse(courseId);
        subjects.forEach(this::initializeSubject);  // Ensure lazy loading is handled
        return subjects;
    }

    private void initializeSubject(Subject subject) {
        if (subject != null && subject.getCourse() != null) {
            subject.getCourse().getName();
        }
    }

	@Override
	public void deleteSubject(Subject subject) {
		this.deleteSubject(subject.getSubjectId());
	}
}
