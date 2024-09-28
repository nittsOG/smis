package com.manage.admin.service;

import com.manage.admin.dao.Admin_SemesterSubjectDAO;
import com.manage.home.entities.SemesterSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminSemesterSubjectServiceImpl")
public class Admin_SemesterSubjectServiceImpl implements Admin_SemesterSubjectService {

    private final Admin_SemesterSubjectDAO adminSemesterSubjectDAO;

    @Autowired
    public Admin_SemesterSubjectServiceImpl(@Qualifier("adminSemesterSubjectDAOImpl") Admin_SemesterSubjectDAO adminSemesterSubjectDAO) {
        this.adminSemesterSubjectDAO = adminSemesterSubjectDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveSemesterSubject(SemesterSubject semesterSubject) {
        adminSemesterSubjectDAO.saveSemesterSubject(semesterSubject);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateSemesterSubject(SemesterSubject semesterSubject) {
        adminSemesterSubjectDAO.updateSemesterSubject(semesterSubject);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteSemesterSubject(Long semesterSubjectId) {
        adminSemesterSubjectDAO.deleteSemesterSubject(semesterSubjectId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public SemesterSubject getSemesterSubjectById(Long semesterSubjectId) {
        return adminSemesterSubjectDAO.getSemesterSubjectById(semesterSubjectId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<SemesterSubject> getAllSemesterSubjects() {
        return adminSemesterSubjectDAO.getAllSemesterSubjects();
    }

	@Override
	public List<SemesterSubject> getSemesterSubjectsBySubjectId(Long subjectId) {
		return adminSemesterSubjectDAO.getSemesterSubjectsBySubjectId(subjectId);
	}
}
