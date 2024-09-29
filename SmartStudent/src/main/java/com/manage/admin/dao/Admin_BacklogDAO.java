package com.manage.admin.dao;

import java.util.List;

import com.manage.student.entities.Backlog;

public interface Admin_BacklogDAO {



	List<Backlog> getAllBacklogs();

	void saveBacklog(Backlog backlog);

	void updateBacklog(Backlog backlog);

	void deleteBacklog(Long studentId, String subjectCode, Integer semester);

	Backlog getBacklogById(Long studentId, String subjectCode, Integer semester);

	List<Backlog> getBacklogsByStudentId(Long studentId);

}
