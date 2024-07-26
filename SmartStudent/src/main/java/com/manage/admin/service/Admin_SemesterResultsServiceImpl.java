package com.manage.admin.service;

import com.manage.admin.dao.Admin_SemesterResultsDAO;
import com.manage.student.entities.SemesterResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminSemesterResultsServiceImpl")
public class Admin_SemesterResultsServiceImpl implements Admin_SemesterResultsService {

    private final Admin_SemesterResultsDAO adminSemesterResultsDAO;

    @Autowired
    public Admin_SemesterResultsServiceImpl(@Qualifier("adminSemesterResultsDAOImpl") Admin_SemesterResultsDAO adminSemesterResultsDAO) {
        this.adminSemesterResultsDAO = adminSemesterResultsDAO;
    }

    @Override
    @Transactional("adminTransactionManager")
    public void saveSemesterResults(SemesterResults semesterResults) {
        adminSemesterResultsDAO.saveSemesterResults(semesterResults);
    }

    @Override
    @Transactional("adminTransactionManager")
    public void updateSemesterResults(SemesterResults semesterResults) {
        adminSemesterResultsDAO.updateSemesterResults(semesterResults);
    }

    @Override
    @Transactional("adminTransactionManager")
    public void deleteSemesterResults(SemesterResults.IdClass id) {
        adminSemesterResultsDAO.deleteSemesterResults(id);
    }

    @Override
    @Transactional("adminTransactionManager")
    public SemesterResults getSemesterResultsById(SemesterResults.IdClass id) {
        return adminSemesterResultsDAO.getSemesterResultsById(id);
    }

    @Override
    @Transactional("adminTransactionManager")
    public List<SemesterResults> getAllSemesterResults() {
        return adminSemesterResultsDAO.getAllSemesterResults();
    }
}
