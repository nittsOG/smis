package com.manage.admin.service;

import com.manage.admin.dao.Admin_SubjectDAO;
import com.manage.home.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return adminSubjectDAO.getSubjectById(subjectId);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return adminSubjectDAO.getAllSubjects();
    }
}
