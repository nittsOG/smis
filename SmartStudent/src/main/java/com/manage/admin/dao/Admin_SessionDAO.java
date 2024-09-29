package com.manage.admin.dao;

import com.manage.home.entities.Session;

import java.util.List;

public interface Admin_SessionDAO {
    void saveSession(Session session);
    void updateSession(Session session);
    void deleteSession(Long sessionId);
    Session getSessionById(Long sessionId);
    List<Session> getAllSessions();
	List<Session> getSessionsBySubject(Long subjectId);
}
