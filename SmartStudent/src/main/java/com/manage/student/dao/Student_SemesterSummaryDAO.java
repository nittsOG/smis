package com.manage.student.dao;

import java.util.List;

import com.manage.student.entities.SemesterSummary;

public interface Student_SemesterSummaryDAO {

	SemesterSummary getSemesterSummaryById(Integer studentId, Integer semester);

	List<SemesterSummary> getAllSemesterSummaries();

	List<SemesterSummary> getSemesterSummariesByStudentId(Integer studentId);

}
