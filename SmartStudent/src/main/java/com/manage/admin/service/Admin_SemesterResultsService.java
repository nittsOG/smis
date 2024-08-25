package com.manage.admin.service;

import java.util.List;

import com.manage.student.entities.SemesterResults;
import com.manage.student.entities.SemesterResults.IdClass;

public interface Admin_SemesterResultsService {

	void saveSemesterResults(SemesterResults semesterResults);

	void updateSemesterResults(SemesterResults semesterResults);

	void deleteSemesterResults(IdClass id);

	SemesterResults getSemesterResultsById(IdClass id);

	List<SemesterResults> getAllSemesterResults();

}
