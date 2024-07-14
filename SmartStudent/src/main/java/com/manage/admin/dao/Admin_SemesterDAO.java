package com.manage.admin.dao;

import com.manage.home.entities.Semester;

import java.util.List;

public interface Admin_SemesterDAO {
    void saveSemester(Semester semester);
    void updateSemester(Semester semester);
    void deleteSemester(Long semesterId);
    Semester getSemesterById(Long semesterId);
    List<Semester> getAllSemesters();
}
