package com.manage.faculty.dao;

import com.manage.home.entities.Session;

public interface Faculty_SessionDAO {
    Session getSessionById(Long sessionId);
    void saveSession(Session session);
    void updateSession(Session session);
    void deleteSession(Session session);
}
