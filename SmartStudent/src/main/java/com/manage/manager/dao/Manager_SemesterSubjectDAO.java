package com.manage.manager.dao;

import java.util.List;

import com.manage.home.entities.SemesterSubject;

public interface Manager_SemesterSubjectDAO {
    SemesterSubject getSemesterSubjectById(Long semesterSubjectId);
    void saveSemesterSubject(SemesterSubject semesterSubject);
    void updateSemesterSubject(SemesterSubject semesterSubject);
    void deleteSemesterSubject(SemesterSubject semesterSubject);
	List<SemesterSubject> getSemesterSubjectsBySubjectId(Long subjectId);
	List<SemesterSubject> getAllSemesterSubjects();
	void deleteSemesterSubject(Long semesterSubjectId);
}
