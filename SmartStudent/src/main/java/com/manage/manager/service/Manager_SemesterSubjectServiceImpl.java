package com.manage.manager.service;

import com.manage.manager.dao.Manager_SemesterSubjectDAO;
import com.manage.home.entities.SemesterSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerSemesterSubjectServiceImpl")
public class Manager_SemesterSubjectServiceImpl implements Manager_SemesterSubjectService {

    private final Manager_SemesterSubjectDAO managerSemesterSubjectDAO;

    @Autowired
    public Manager_SemesterSubjectServiceImpl(@Qualifier("managerSemesterSubjectDAOImpl") Manager_SemesterSubjectDAO managerSemesterSubjectDAO) {
        this.managerSemesterSubjectDAO = managerSemesterSubjectDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveSemesterSubject(SemesterSubject semesterSubject) {
        managerSemesterSubjectDAO.saveSemesterSubject(semesterSubject);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateSemesterSubject(SemesterSubject semesterSubject) {
        managerSemesterSubjectDAO.updateSemesterSubject(semesterSubject);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteSemesterSubject(Long semesterSubjectId) {
        managerSemesterSubjectDAO.deleteSemesterSubject(semesterSubjectId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public SemesterSubject getSemesterSubjectById(Long semesterSubjectId) {
        return managerSemesterSubjectDAO.getSemesterSubjectById(semesterSubjectId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<SemesterSubject> getAllSemesterSubjects() {
        return managerSemesterSubjectDAO.getAllSemesterSubjects();
    }

    @Override
    public List<SemesterSubject> getSemesterSubjectsBySubjectId(Long subjectId) {
        return managerSemesterSubjectDAO.getSemesterSubjectsBySubjectId(subjectId);
    }

	@Override
	public void deleteSemesterSubject(SemesterSubject semesterSubject) {
		managerSemesterSubjectDAO.deleteSemesterSubject(semesterSubject);
	}
}
