package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.SemesterSubject;
import com.manage.manager.dao.Manager_SemesterSubjectDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_SemesterSubjectServiceImpl implements Manager_SemesterSubjectService {

    private final Manager_SemesterSubjectDAO managerSemesterSubjectDAO;

    @Autowired
    public Manager_SemesterSubjectServiceImpl(Manager_SemesterSubjectDAO managerSemesterSubjectDAO) {
        this.managerSemesterSubjectDAO = managerSemesterSubjectDAO;
    }

    @Override
    public SemesterSubject getSemesterSubjectById(Long semesterSubjectId) {
        return managerSemesterSubjectDAO.getSemesterSubjectById(semesterSubjectId);
    }

    @Override
    public void saveSemesterSubject(SemesterSubject semesterSubject) {
        managerSemesterSubjectDAO.saveSemesterSubject(semesterSubject);
    }

    @Override
    public void updateSemesterSubject(SemesterSubject semesterSubject) {
        managerSemesterSubjectDAO.updateSemesterSubject(semesterSubject);
    }

    @Override
    public void deleteSemesterSubject(SemesterSubject semesterSubject) {
        managerSemesterSubjectDAO.deleteSemesterSubject(semesterSubject);
    }
}
