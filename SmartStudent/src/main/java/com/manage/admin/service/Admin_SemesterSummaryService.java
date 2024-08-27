package com.manage.admin.service;

import java.util.List;

import com.manage.student.entities.SemesterSummary;

public interface Admin_SemesterSummaryService {

	void saveSemesterSummary(SemesterSummary semesterSummary);

	void updateSemesterSummary(SemesterSummary semesterSummary);

	void deleteSemesterSummary(Long studentId, Integer semester);

	SemesterSummary getSemesterSummaryById(Long studentId, Integer semester);

	List<SemesterSummary> getAllSemesterSummaries();

}
