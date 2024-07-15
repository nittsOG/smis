package com.manage.faculty.dao;

import com.manage.faculty.entities.FacultyDivision;
import java.util.List;

public interface Faculty_FacultyDivisionDAO {
    FacultyDivision getFacultyDivisionById(Long facultyDivisionId);
    List<FacultyDivision> getAllFacultyDivisions();
    void updateFacultyDivision(FacultyDivision facultyDivision);
}
