package com.manage.faculty.dao;

import com.manage.home.entities.Semester;

public interface Faculty_SemesterDAO {
    Semester getSemesterById(Long semesterId);
    void saveSemester(Semester semester);
    void updateSemester(Semester semester);
    void deleteSemester(Semester semester);
}
