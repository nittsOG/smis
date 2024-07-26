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
public class Admin_SemesterSummaryServiceImpl implements Admin_SemesterSummaryService {

    private final Admin_SemesterSummaryDAO adminSemesterSummaryDAO;

    @Autowired
    public Admin_SemesterSummaryServiceImpl(@Qualifier("adminSemesterSummaryDAOImpl") Admin_SemesterSummaryDAO adminSemesterSummaryDAO) {
        this.adminSemesterSummaryDAO = adminSemesterSummaryDAO;
    }

    @Override
    @Transactional("adminTransactionManager")
    public void saveSemesterSummary(SemesterSummary semesterSummary) {
        adminSemesterSummaryDAO.saveSemesterSummary(semesterSummary);
    }

    @Override
    @Transactional("adminTransactionManager")
    public void updateSemesterSummary(SemesterSummary semesterSummary) {
        adminSemesterSummaryDAO.updateSemesterSummary(semesterSummary);
    }

    @Override
    @Transactional("adminTransactionManager")
    public void deleteSemesterSummary(Integer studentId, Integer semester) {
        adminSemesterSummaryDAO.deleteSemesterSummary(studentId, semester);
    }

    @Override
    @Transactional("adminTransactionManager")
    public SemesterSummary getSemesterSummaryById(Integer studentId, Integer semester) {
        return adminSemesterSummaryDAO.getSemesterSummaryById(studentId, semester);
    }

    @Override
    @Transactional("adminTransactionManager")
    public List<SemesterSummary> getAllSemesterSummaries() {
        return adminSemesterSummaryDAO.getAllSemesterSummaries();
    }
}
