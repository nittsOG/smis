package com.manage.student.service;

import com.manage.home.entities.Session;
import com.manage.student.dao.Student_SessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("studentSessionServiceImpl")
public class StudentSessionServiceImpl implements StudentSessionService {

    private final Student_SessionDao sessionDao;

    @Autowired
    public StudentSessionServiceImpl(@Qualifier("studentSessionDaoImpl") Student_SessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public Session findById(Long id) {
        return sessionDao.findById(id);
    }

    // Implement more service methods if needed
}
