package com.manage.student.dao;

import java.util.List;

import com.manage.student.entities.Backlog;

public interface Student_BacklogDAO {

	List<Backlog> getAllBacklogs();

	Backlog getBacklogById(Long studentId, String subjectCode, Integer semester);

	List<Backlog> getBacklogsByStudentId(Long studentId);

}
