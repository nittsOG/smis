package com.manage.manager.dao;

import java.util.List;

import com.manage.student.entities.Backlog;

public interface Manager_BacklogDAO {

	void saveBacklog(Backlog backlog);

	void updateBacklog(Backlog backlog);

	void deleteBacklog(Long studentId, String subjectCode, Integer semester);

	Backlog getBacklogById(Long studentId, String subjectCode, Integer semester);

	List<Backlog> getAllBacklogs();

}
