package com.manage.student.dao;

import java.util.List;

import com.manage.student.entities.Backlog;

public interface Student_BacklogDAO {

	Backlog getBacklogById(Integer studentId, String subjectCode, Integer semester);

	List<Backlog> getAllBacklogs();

	List<Backlog> getBacklogsByStudentId(Integer studentId);

}
