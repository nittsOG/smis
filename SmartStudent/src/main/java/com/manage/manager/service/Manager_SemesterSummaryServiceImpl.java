package com.manage.manager.service;

import com.manage.manager.dao.Manager_SemesterSummaryDAO;
import com.manage.student.entities.SemesterSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerSemesterSummaryServiceImpl")
@Transactional(transactionManager = "managerTransactionManager")
public class Manager_SemesterSummaryServiceImpl implements Manager_SemesterSummaryService {

    private final Manager_SemesterSummaryDAO managerSemesterSummaryDAO;

    @Autowired
    public Manager_SemesterSummaryServiceImpl(@Qualifier("managerSemesterSummaryDAOImpl") Manager_SemesterSummaryDAO managerSemesterSummaryDAO) {
        this.managerSemesterSummaryDAO = managerSemesterSummaryDAO;
    }

    @Override
    public void saveSemesterSummary(SemesterSummary semesterSummary) {
        managerSemesterSummaryDAO.saveSemesterSummary(semesterSummary);
    }

    @Override
    public void updateSemesterSummary(SemesterSummary semesterSummary) {
        managerSemesterSummaryDAO.updateSemesterSummary(semesterSummary);
    }

    @Override
    public void deleteSemesterSummary(Long studentId, Integer semester) {
        managerSemesterSummaryDAO.deleteSemesterSummary(studentId, semester);
    }

    @Override
    public SemesterSummary getSemesterSummaryById(Long studentId, Integer semester) {
        SemesterSummary semesterSummary = managerSemesterSummaryDAO.getSemesterSummaryById(studentId, semester);
        // If there are any lazy-loaded properties, initialize them here
        return semesterSummary;
    }

    @Override
    public List<SemesterSummary> getAllSemesterSummaries() {
        List<SemesterSummary> semesterSummaries = managerSemesterSummaryDAO.getAllSemesterSummaries();
        // If there are any lazy-loaded properties, initialize them here
        return semesterSummaries;
    }
}
