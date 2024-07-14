package com.manage.student.service;

import com.manage.home.entities.SemesterSubject;
import com.manage.student.dao.Student_SemesterSubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("studentSemesterSubjectServiceImpl")
public class StudentSemesterSubjectServiceImpl implements StudentSemesterSubjectService {

    private final Student_SemesterSubjectDao semesterSubjectDao;

    @Autowired
    public StudentSemesterSubjectServiceImpl(@Qualifier("studentSemesterSubjectDaoImpl") Student_SemesterSubjectDao semesterSubjectDao) {
        this.semesterSubjectDao = semesterSubjectDao;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public SemesterSubject findById(Long id) {
        return semesterSubjectDao.findById(id);
    }

    // Implement more service methods if needed
}
