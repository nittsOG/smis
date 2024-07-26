package com.manage.admin.service;

import java.util.List;

import com.manage.student.entities.Backlog;

public interface Admin_BacklogService {

	void saveBacklog(Backlog backlog);

	void updateBacklog(Backlog backlog);

	void deleteBacklog(Integer studentId, String subjectCode, Integer semester);

	Backlog getBacklogById(Integer studentId, String subjectCode, Integer semester);

	List<Backlog> getAllBacklogs();

}
