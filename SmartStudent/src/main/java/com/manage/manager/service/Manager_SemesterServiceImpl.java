package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Semester;
import com.manage.manager.dao.Manager_SemesterDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_SemesterServiceImpl implements Manager_SemesterService {

    private final Manager_SemesterDAO managerSemesterDAO;

    @Autowired
    public Manager_SemesterServiceImpl(Manager_SemesterDAO managerSemesterDAO) {
        this.managerSemesterDAO = managerSemesterDAO;
    }

    @Override
    public Semester getSemesterById(Long semesterId) {
        return managerSemesterDAO.getSemesterById(semesterId);
    }

    @Override
    public void saveSemester(Semester semester) {
        managerSemesterDAO.saveSemester(semester);
    }

    @Override
    public void updateSemester(Semester semester) {
        managerSemesterDAO.updateSemester(semester);
    }

    @Override
    public void deleteSemester(Semester semester) {
        managerSemesterDAO.deleteSemester(semester);
    }
}
