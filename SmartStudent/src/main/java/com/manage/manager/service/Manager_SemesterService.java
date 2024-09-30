package com.manage.manager.service;

import java.util.List;

import com.manage.home.entities.Semester;

public interface Manager_SemesterService {
    Semester getSemesterById(Long semesterId);
    void saveSemester(Semester semester);
    void updateSemester(Semester semester);
    void deleteSemester(Semester semester);
	List<Semester> getSemestersByCourseId(Long courseId);
	List<Semester> getAllSemesters();
	void deleteSemester(Long semesterId);
}
