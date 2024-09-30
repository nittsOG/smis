package com.manage.manager.dao;

import java.util.List;

import com.manage.home.entities.Session;

public interface Manager_SessionDAO {

	void saveSession(Session session);

	void updateSession(Session session);

	void deleteSession(Long sessionId);

	Session getSessionById(Long sessionId);

	List<Session> getAllSessions();

	List<Session> getSessionsBySubject(Long subjectId);

}
