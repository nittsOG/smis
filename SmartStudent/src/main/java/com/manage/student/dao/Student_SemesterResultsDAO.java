package com.manage.student.dao;

import java.util.List;

import com.manage.student.entities.SemesterResults;
import com.manage.student.entities.SemesterResults.IdClass;

public interface Student_SemesterResultsDAO {

	SemesterResults getSemesterResultsById(IdClass id);

	List<SemesterResults> getAllSemesterResults();

	List<SemesterResults> getSemesterResultsByStudentId(Integer studentId);

	List<SemesterResults> findResultsByStudentId(Long studentId);

}
