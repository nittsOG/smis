package com.manage.admin.service;

import com.manage.admin.dao.Admin_SemesterSummaryDAO;
import com.manage.student.entities.SemesterSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminSemesterSummaryServiceImpl")
@Transactional(transactionManager = "adminTransactionManager")
public class Admin_SemesterSummaryServiceImpl implements Admin_SemesterSummaryService {

    private final Admin_SemesterSummaryDAO adminSemesterSummaryDAO;

    @Autowired
    public Admin_SemesterSummaryServiceImpl(@Qualifier("adminSemesterSummaryDAOImpl") Admin_SemesterSummaryDAO adminSemesterSummaryDAO) {
        this.adminSemesterSummaryDAO = adminSemesterSummaryDAO;
    }

    @Override
    public void saveSemesterSummary(SemesterSummary semesterSummary) {
        adminSemesterSummaryDAO.saveSemesterSummary(semesterSummary);
    }

    @Override
    public void updateSemesterSummary(SemesterSummary semesterSummary) {
        adminSemesterSummaryDAO.updateSemesterSummary(semesterSummary);
    }

    @Override
    public void deleteSemesterSummary(Long studentId, Integer semester) {
        adminSemesterSummaryDAO.deleteSemesterSummary(studentId, semester);
    }

    @Override
    public SemesterSummary getSemesterSummaryById(Long studentId, Integer semester) {
        SemesterSummary semesterSummary = adminSemesterSummaryDAO.getSemesterSummaryById(studentId, semester);
        // If there are any lazy-loaded properties, initialize them here
        return semesterSummary;
    }

    @Override
    public List<SemesterSummary> getAllSemesterSummaries() {
        List<SemesterSummary> semesterSummaries = adminSemesterSummaryDAO.getAllSemesterSummaries();
        // If there are any lazy-loaded properties, initialize them here
        return semesterSummaries;
    }
}
