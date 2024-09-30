package com.manage.manager.service;

import com.manage.manager.dao.Manager_StudentSemesterSubjectDAO;
import com.manage.student.entities.StudentSemesterSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerStudentSemesterSubjectServiceImpl")
public class Manager_StudentSemesterSubjectServiceImpl implements Manager_StudentSemesterSubjectService {

    private final Manager_StudentSemesterSubjectDAO managerStudentSemesterSubjectDAO;

    @Autowired
    public Manager_StudentSemesterSubjectServiceImpl(@Qualifier("managerStudentSemesterSubjectDAOImpl") Manager_StudentSemesterSubjectDAO managerStudentSemesterSubjectDAO) {
        this.managerStudentSemesterSubjectDAO = managerStudentSemesterSubjectDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public StudentSemesterSubject getStudentSemesterSubjectById(Long studentSemesterSubjectId) {
        StudentSemesterSubject studentSemesterSubject = managerStudentSemesterSubjectDAO.getStudentSemesterSubjectById(studentSemesterSubjectId);
        initializeStudentSemesterSubject(studentSemesterSubject);
        return studentSemesterSubject;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        managerStudentSemesterSubjectDAO.saveStudentSemesterSubject(studentSemesterSubject);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        managerStudentSemesterSubjectDAO.updateStudentSemesterSubject(studentSemesterSubject);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteStudentSemesterSubject(Long studentSemesterSubjectId) {
        StudentSemesterSubject studentSemesterSubject = getStudentSemesterSubjectById(studentSemesterSubjectId);
        managerStudentSemesterSubjectDAO.deleteStudentSemesterSubject(studentSemesterSubject);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<StudentSemesterSubject> getAllStudentSemesterSubjects() {
        List<StudentSemesterSubject> studentSemesterSubjects = managerStudentSemesterSubjectDAO.getAllStudentSemesterSubjects();
        studentSemesterSubjects.forEach(this::initializeStudentSemesterSubject);
        return studentSemesterSubjects;
    }

    private void initializeStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        if (studentSemesterSubject != null && studentSemesterSubject.getSubject() != null) {
            studentSemesterSubject.getSubject().getName();
        }
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<StudentSemesterSubject> getStudentSemesterSubjectsByStudentId(Long studentId) {
        List<StudentSemesterSubject> studentSemesterSubjects = managerStudentSemesterSubjectDAO.getStudentSemesterSubjectsByStudentId(studentId);
        studentSemesterSubjects.forEach(this::initializeStudentSemesterSubject);
        return studentSemesterSubjects;
    }

	@Override
	public void deleteStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
		this.deleteStudentSemesterSubject(studentSemesterSubject.getStudentSemesterSubjectId());
	}
}
