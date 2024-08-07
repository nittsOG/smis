package com.manage.admin.service;

import com.manage.admin.dao.Admin_StudentSemesterSubjectDAO;
import com.manage.student.entities.StudentSemesterSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("adminStudentSemesterSubjectServiceImpl")
public class Admin_StudentSemesterSubjectServiceImpl implements Admin_StudentSemesterSubjectService {

    private final Admin_StudentSemesterSubjectDAO adminStudentSemesterSubjectDAO;

    @Autowired
    public Admin_StudentSemesterSubjectServiceImpl(@Qualifier("adminStudentSemesterSubjectDAOImpl") Admin_StudentSemesterSubjectDAO adminStudentSemesterSubjectDAO) {
        this.adminStudentSemesterSubjectDAO = adminStudentSemesterSubjectDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public StudentSemesterSubject getStudentSemesterSubjectById(Long studentSemesterSubjectId) {
        return adminStudentSemesterSubjectDAO.getStudentSemesterSubjectById(studentSemesterSubjectId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        adminStudentSemesterSubjectDAO.saveStudentSemesterSubject(studentSemesterSubject);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        adminStudentSemesterSubjectDAO.updateStudentSemesterSubject(studentSemesterSubject);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteStudentSemesterSubject(Long studentSemesterSubjectId) {
        StudentSemesterSubject studentSemesterSubject = getStudentSemesterSubjectById(studentSemesterSubjectId);
        adminStudentSemesterSubjectDAO.deleteStudentSemesterSubject(studentSemesterSubject);
    }
}
