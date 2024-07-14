package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.StudentSemester;
import com.manage.manager.dao.Manager_StudentSemesterDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_StudentSemesterServiceImpl implements Manager_StudentSemesterService {

    private final Manager_StudentSemesterDAO managerStudentSemesterDAO;

    @Autowired
    public Manager_StudentSemesterServiceImpl(Manager_StudentSemesterDAO managerStudentSemesterDAO) {
        this.managerStudentSemesterDAO = managerStudentSemesterDAO;
    }

    @Override
    public StudentSemester getStudentSemesterById(Long studentSemesterId) {
        return managerStudentSemesterDAO.getStudentSemesterById(studentSemesterId);
    }

    @Override
    public void saveStudentSemester(StudentSemester studentSemester) {
        managerStudentSemesterDAO.saveStudentSemester(studentSemester);
    }

    @Override
    public void updateStudentSemester(StudentSemester studentSemester) {
        managerStudentSemesterDAO.updateStudentSemester(studentSemester);
    }

    @Override
    public void deleteStudentSemester(StudentSemester studentSemester) {
        managerStudentSemesterDAO.deleteStudentSemester(studentSemester);
    }
}
