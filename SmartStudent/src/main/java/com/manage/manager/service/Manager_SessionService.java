package com.manage.manager.service;

import java.util.List;

import com.manage.home.entities.Session;

public interface Manager_SessionService {

	void saveSession(Session session);

	void updateSession(Session session);

	void deleteSession(Long sessionId);

	Session getSessionById(Long sessionId);

	List<Session> getAllSessions();

	List<Session> getSessionsBySubject(Long subjectId);

}
