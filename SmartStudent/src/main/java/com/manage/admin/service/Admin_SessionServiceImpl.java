package com.manage.admin.service;

import com.manage.admin.dao.Admin_SessionDAO;
import com.manage.home.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminSessionServiceImpl")
public class Admin_SessionServiceImpl implements Admin_SessionService {

    private final Admin_SessionDAO adminSessionDAO;

    @Autowired
    public Admin_SessionServiceImpl(@Qualifier("adminSessionDAOImpl") Admin_SessionDAO adminSessionDAO) {
        this.adminSessionDAO = adminSessionDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveSession(Session session) {
        adminSessionDAO.saveSession(session);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateSession(Session session) {
        adminSessionDAO.updateSession(session);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteSession(Long sessionId) {
        adminSessionDAO.deleteSession(sessionId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Session getSessionById(Long sessionId) {
        return adminSessionDAO.getSessionById(sessionId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Session> getAllSessions() {
        return adminSessionDAO.getAllSessions();
    }
}
