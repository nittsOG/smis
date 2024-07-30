package com.manage.admin.service;

import com.manage.admin.dao.Admin_SemesterResultsDAO;
import com.manage.student.entities.SemesterResults;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminSemesterResultsServiceImpl")
@Transactional(transactionManager = "adminTransactionManager")
public class Admin_SemesterResultsServiceImpl implements Admin_SemesterResultsService {

    private final Admin_SemesterResultsDAO adminSemesterResultsDAO;

    @Autowired
    public Admin_SemesterResultsServiceImpl(@Qualifier("adminSemesterResultsDAOImpl") Admin_SemesterResultsDAO adminSemesterResultsDAO) {
        this.adminSemesterResultsDAO = adminSemesterResultsDAO;
    }

    @Override
    public void saveSemesterResults(SemesterResults semesterResults) {
        adminSemesterResultsDAO.saveSemesterResults(semesterResults);
    }

    @Override
    public void updateSemesterResults(SemesterResults semesterResults) {
        adminSemesterResultsDAO.updateSemesterResults(semesterResults);
    }

    @Override
    public void deleteSemesterResults(SemesterResults.IdClass id) {
        adminSemesterResultsDAO.deleteSemesterResults(id);
    }

    @Override
    public SemesterResults getSemesterResultsById(SemesterResults.IdClass id) {
        SemesterResults semesterResults = adminSemesterResultsDAO.getSemesterResultsById(id);
        // Initialize lazy property
        if (semesterResults != null && semesterResults.getStudentId() != null) {
            Hibernate.initialize(semesterResults.getStudentId()); // Ensure student is initialized
        }
        return semesterResults;
    }

    @Override
    public List<SemesterResults> getAllSemesterResults() {
        List<SemesterResults> semesterResultsList = adminSemesterResultsDAO.getAllSemesterResults();
        for (SemesterResults semesterResults : semesterResultsList) {
            // Initialize lazy property
            if (semesterResults.getStudentId() != null) {
                Hibernate.initialize(semesterResults.getStudentId()); // Ensure student is initialized
            }
        }
        return semesterResultsList;
    }
}
