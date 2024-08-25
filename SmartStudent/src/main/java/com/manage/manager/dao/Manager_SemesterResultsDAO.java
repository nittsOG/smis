package com.manage.manager.dao;

import java.util.List;

import com.manage.student.entities.SemesterResults;
import com.manage.student.entities.SemesterResults.IdClass;

public interface Manager_SemesterResultsDAO {

	void saveSemesterResults(SemesterResults semesterResults);

	void updateSemesterResults(SemesterResults semesterResults);

	void deleteSemesterResults(IdClass id);

	SemesterResults getSemesterResultsById(IdClass id);

	List<SemesterResults> getAllSemesterResults();

}
