package com.manage.admin.service;

import com.manage.home.entities.Semester;

import java.util.List;

public interface Admin_SemesterService {
    void saveSemester(Semester semester);

    void updateSemester(Semester semester);

    void deleteSemester(Long semesterId);

    Semester getSemesterById(Long semesterId);

    List<Semester> getAllSemesters();

	List<Semester> getSemestersByCourseId(Long courseId);
}
