package com.manage.admin.service;

import com.manage.admin.dao.Admin_StudentSemesterDAO;
import com.manage.student.entities.StudentSemester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("adminStudentSemesterServiceImpl")
public class Admin_StudentSemesterServiceImpl implements Admin_StudentSemesterService {

    private final Admin_StudentSemesterDAO adminStudentSemesterDAO;

    @Autowired
    public Admin_StudentSemesterServiceImpl(@Qualifier("adminStudentSemesterDAOImpl") Admin_StudentSemesterDAO adminStudentSemesterDAO) {
        this.adminStudentSemesterDAO = adminStudentSemesterDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public StudentSemester getStudentSemesterById(Long studentSemesterId) {
        return adminStudentSemesterDAO.getStudentSemesterById(studentSemesterId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveStudentSemester(StudentSemester studentSemester) {
        adminStudentSemesterDAO.saveStudentSemester(studentSemester);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateStudentSemester(StudentSemester studentSemester) {
        adminStudentSemesterDAO.updateStudentSemester(studentSemester);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteStudentSemester(Long studentSemesterId) {
        StudentSemester studentSemester = getStudentSemesterById(studentSemesterId);
        adminStudentSemesterDAO.deleteStudentSemester(studentSemester);
    }
}
