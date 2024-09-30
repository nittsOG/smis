package com.manage.manager.service;

import com.manage.manager.dao.Manager_SemesterResultsDAO;
import com.manage.student.entities.SemesterResults;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerSemesterResultsServiceImpl")
@Transactional(transactionManager = "managerTransactionManager")
public class Manager_SemesterResultsServiceImpl implements Manager_SemesterResultsService {

    private final Manager_SemesterResultsDAO managerSemesterResultsDAO;

    @Autowired
    public Manager_SemesterResultsServiceImpl(@Qualifier("managerSemesterResultsDAOImpl") Manager_SemesterResultsDAO managerSemesterResultsDAO) {
        this.managerSemesterResultsDAO = managerSemesterResultsDAO;
    }

    @Override
    public void saveSemesterResults(SemesterResults semesterResults) {
        managerSemesterResultsDAO.saveSemesterResults(semesterResults);
    }

    @Override
    public void updateSemesterResults(SemesterResults semesterResults) {
        managerSemesterResultsDAO.updateSemesterResults(semesterResults);
    }

    @Override
    public void deleteSemesterResults(SemesterResults.IdClass id) {
        managerSemesterResultsDAO.deleteSemesterResults(id);
    }

    @Override
    public SemesterResults getSemesterResultsById(SemesterResults.IdClass id) {
        SemesterResults semesterResults = managerSemesterResultsDAO.getSemesterResultsById(id);
        // Initialize lazy property
        if (semesterResults != null && semesterResults.getStudentId() != null) {
            Hibernate.initialize(semesterResults.getStudentId()); // Ensure student is initialized
        }
        return semesterResults;
    }

    @Override
    public List<SemesterResults> getAllSemesterResults() {
        List<SemesterResults> semesterResultsList = managerSemesterResultsDAO.getAllSemesterResults();
        for (SemesterResults semesterResults : semesterResultsList) {
            // Initialize lazy property
            if (semesterResults.getStudentId() != null) {
                Hibernate.initialize(semesterResults.getStudentId()); // Ensure student is initialized
            }
        }
        return semesterResultsList;
    }
}
