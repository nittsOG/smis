package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Subject;
import com.manage.manager.dao.Manager_SubjectDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_SubjectServiceImpl implements Manager_SubjectService {

    private final Manager_SubjectDAO managerSubjectDAO;

    @Autowired
    public Manager_SubjectServiceImpl(Manager_SubjectDAO managerSubjectDAO) {
        this.managerSubjectDAO = managerSubjectDAO;
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        return managerSubjectDAO.getSubjectById(subjectId);
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
    public void deleteSubject(Subject subject) {
        managerSubjectDAO.deleteSubject(subject);
    }
}
