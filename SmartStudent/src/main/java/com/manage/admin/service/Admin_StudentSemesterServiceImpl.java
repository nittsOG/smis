package com.manage.admin.service;

import com.manage.admin.dao.Admin_StudentSemesterDAO;
import com.manage.student.entities.StudentSemester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        StudentSemester studentSemester = adminStudentSemesterDAO.getStudentSemesterById(studentSemesterId);
        initializeStudentSemester(studentSemester);
        return studentSemester;
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
        if (studentSemester != null) {
            adminStudentSemesterDAO.deleteStudentSemester(studentSemester);
        }
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<StudentSemester> getAllStudentSemesters() {
        List<StudentSemester> studentSemesters = adminStudentSemesterDAO.getAllStudentSemesters();
        studentSemesters.forEach(this::initializeStudentSemester);
        return studentSemesters;
    }
    
    

    private void initializeStudentSemester(StudentSemester studentSemester) {
        if (studentSemester != null) {
            if (studentSemester.getStudent() != null) {
                studentSemester.getStudent().getUsername(); // Force initialization of the Student entity
            }
            if (studentSemester.getSemester() != null) {
                studentSemester.getSemester().getName(); // Force initialization of the Semester entity
            }
        }
    }
}
