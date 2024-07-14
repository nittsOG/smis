package com.manage.admin.service;

import com.manage.home.entities.Session;

import java.util.List;

public interface Admin_SessionService {
    void saveSession(Session session);

    void updateSession(Session session);

    void deleteSession(Long sessionId);

    Session getSessionById(Long sessionId);

    List<Session> getAllSessions();
}
