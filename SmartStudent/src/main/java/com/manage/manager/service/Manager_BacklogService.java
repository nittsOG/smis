package com.manage.manager.service;

import java.util.List;

import com.manage.student.entities.Backlog;

public interface Manager_BacklogService {

	void saveBacklog(Backlog backlog);

	void updateBacklog(Backlog backlog);

	void deleteBacklog(Long studentId, String subjectCode, Integer semester);

	Backlog getBacklogById(Long studentId, String subjectCode, Integer semester);

	List<Backlog> getAllBacklogs();

	List<Backlog> getBacklogsByStudentId(Long studentId);

}
