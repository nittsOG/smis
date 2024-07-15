package com.manage.admin.dao;

import java.util.List;

import com.manage.faculty.entities.FacultyDivision;

public interface Admin_FacultyDivisionDAO {
    void saveFacultyDivision(FacultyDivision facultyDivision);
    void updateFacultyDivision(FacultyDivision facultyDivision);
    void deleteFacultyDivision(Long facultyDivisionId);
    FacultyDivision getFacultyDivisionById(Long facultyDivisionId);
    List<FacultyDivision> getAllFacultyDivisions();
}
