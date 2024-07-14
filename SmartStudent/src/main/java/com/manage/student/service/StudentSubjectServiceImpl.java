package com.manage.student.service;

import com.manage.home.entities.Subject;
import com.manage.student.dao.Student_SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("studentSubjectServiceImpl")
public class StudentSubjectServiceImpl implements StudentSubjectService {

    private final Student_SubjectDao subjectDao;

    @Autowired
    public StudentSubjectServiceImpl(@Qualifier("studentSubjectDaoImpl") Student_SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public Subject findById(Long id) {
        return subjectDao.findById(id);
    }

    // Implement more service methods if needed
}
