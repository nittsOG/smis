package com.manage.admin.service;

import com.manage.faculty.entities.FacultyDivision;
import java.util.List;

public interface Admin_FacultyDivisionService {
    void saveFacultyDivision(FacultyDivision facultyDivision);
    void updateFacultyDivision(FacultyDivision facultyDivision);
    void deleteFacultyDivision(Long facultyDivisionId);
    FacultyDivision getFacultyDivisionById(Long facultyDivisionId);
    List<FacultyDivision> getAllFacultyDivisions();
}
