package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.StudentSemesterSubject;
import com.manage.manager.dao.Manager_StudentSemesterSubjectDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_StudentSemesterSubjectServiceImpl implements Manager_StudentSemesterSubjectService {

    private final Manager_StudentSemesterSubjectDAO managerStudentSemesterSubjectDAO;

    @Autowired
    public Manager_StudentSemesterSubjectServiceImpl(Manager_StudentSemesterSubjectDAO managerStudentSemesterSubjectDAO) {
        this.managerStudentSemesterSubjectDAO = managerStudentSemesterSubjectDAO;
    }

    @Override
    public StudentSemesterSubject getStudentSemesterSubjectById(Long studentSemesterSubjectId) {
        return managerStudentSemesterSubjectDAO.getStudentSemesterSubjectById(studentSemesterSubjectId);
    }

    @Override
    public void saveStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        managerStudentSemesterSubjectDAO.saveStudentSemesterSubject(studentSemesterSubject);
    }

    @Override
    public void updateStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        managerStudentSemesterSubjectDAO.updateStudentSemesterSubject(studentSemesterSubject);
    }

    @Override
    public void deleteStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        managerStudentSemesterSubjectDAO.deleteStudentSemesterSubject(studentSemesterSubject);
    }
}
