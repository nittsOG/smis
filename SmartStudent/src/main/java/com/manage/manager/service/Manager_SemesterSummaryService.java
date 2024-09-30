package com.manage.manager.service;

import java.util.List;

import com.manage.student.entities.SemesterSummary;

public interface Manager_SemesterSummaryService {

	void saveSemesterSummary(SemesterSummary semesterSummary);

	void updateSemesterSummary(SemesterSummary semesterSummary);

	void deleteSemesterSummary(Long studentId, Integer semester);

	SemesterSummary getSemesterSummaryById(Long studentId, Integer semester);

	List<SemesterSummary> getAllSemesterSummaries();

}
