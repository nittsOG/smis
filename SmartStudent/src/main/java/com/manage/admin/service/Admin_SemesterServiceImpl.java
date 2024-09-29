package com.manage.admin.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.admin.dao.Admin_SemesterDAO;
import com.manage.home.entities.Semester;

@Service
@Qualifier("adminSemesterServiceImpl")
public class Admin_SemesterServiceImpl implements Admin_SemesterService {

    private final Admin_SemesterDAO adminSemesterDAO;

    @Autowired
    public Admin_SemesterServiceImpl(@Qualifier("adminSemesterDAOImpl") Admin_SemesterDAO adminSemesterDAO) {
        this.adminSemesterDAO = adminSemesterDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveSemester(Semester semester) {
        adminSemesterDAO.saveSemester(semester);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateSemester(Semester semester) {
        adminSemesterDAO.updateSemester(semester);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteSemester(Long semesterId) {
        adminSemesterDAO.deleteSemester(semesterId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Semester getSemesterById(Long semesterId) {
        return adminSemesterDAO.getSemesterById(semesterId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Semester> getAllSemesters() {
        return adminSemesterDAO.getAllSemesters();
    }
    
    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Semester> getSemestersByCourseId(Long courseId) {
        List<Semester> semesters = adminSemesterDAO.getSemestersByCourseId(courseId);
        
        for (Semester semester : semesters) {
            Hibernate.initialize(semester.getCourse()); // Manually initialize the course
        }

        return semesters;
    }

}
