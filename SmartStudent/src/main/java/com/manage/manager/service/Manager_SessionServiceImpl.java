package com.manage.manager.service;

import com.manage.manager.dao.Manager_SessionDAO;
import com.manage.home.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerSessionServiceImpl")
public class Manager_SessionServiceImpl implements Manager_SessionService {

    private final Manager_SessionDAO managerSessionDAO;

    @Autowired
    public Manager_SessionServiceImpl(@Qualifier("managerSessionDAOImpl") Manager_SessionDAO managerSessionDAO) {
        this.managerSessionDAO = managerSessionDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveSession(Session session) {
        managerSessionDAO.saveSession(session);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateSession(Session session) {
        managerSessionDAO.updateSession(session);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteSession(Long sessionId) {
        managerSessionDAO.deleteSession(sessionId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Session getSessionById(Long sessionId) {
        return managerSessionDAO.getSessionById(sessionId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Session> getAllSessions() {
        return managerSessionDAO.getAllSessions();
    }

    @Override
    public List<Session> getSessionsBySubject(Long subjectId) {
        return managerSessionDAO.getSessionsBySubject(subjectId);
    }
}
