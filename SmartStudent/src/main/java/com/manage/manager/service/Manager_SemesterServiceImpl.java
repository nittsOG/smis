package com.manage.manager.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.manager.dao.Manager_SemesterDAO;
import com.manage.home.entities.Semester;

@Service
@Qualifier("managerSemesterServiceImpl")
public class Manager_SemesterServiceImpl implements Manager_SemesterService {

    private final Manager_SemesterDAO managerSemesterDAO;

    @Autowired
    public Manager_SemesterServiceImpl(@Qualifier("managerSemesterDAOImpl") Manager_SemesterDAO managerSemesterDAO) {
        this.managerSemesterDAO = managerSemesterDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveSemester(Semester semester) {
        managerSemesterDAO.saveSemester(semester);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateSemester(Semester semester) {
        managerSemesterDAO.updateSemester(semester);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteSemester(Long semesterId) {
        managerSemesterDAO.deleteSemester(semesterId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Semester getSemesterById(Long semesterId) {
        return managerSemesterDAO.getSemesterById(semesterId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Semester> getAllSemesters() {
        return managerSemesterDAO.getAllSemesters();
    }
    
    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Semester> getSemestersByCourseId(Long courseId) {
        List<Semester> semesters = managerSemesterDAO.getSemestersByCourseId(courseId);
        
        for (Semester semester : semesters) {
            Hibernate.initialize(semester.getCourse()); // Manually initialize the course
        }

        return semesters;
    }

	@Override
	public void deleteSemester(Semester semester) {
		managerSemesterDAO.deleteSemester(semester);
	}
}
