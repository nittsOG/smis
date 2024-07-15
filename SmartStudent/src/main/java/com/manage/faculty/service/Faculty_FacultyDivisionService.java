package com.manage.faculty.service;

import com.manage.faculty.entities.FacultyDivision;
import java.util.List;

public interface Faculty_FacultyDivisionService {
    void updateFacultyDivision(FacultyDivision facultyDivision);
    FacultyDivision getFacultyDivisionById(Long facultyDivisionId);
    List<FacultyDivision> getAllFacultyDivisions();
}
