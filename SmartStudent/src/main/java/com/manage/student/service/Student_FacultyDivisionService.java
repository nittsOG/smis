package com.manage.student.service;

import com.manage.faculty.entities.FacultyDivision;
import java.util.List;

public interface Student_FacultyDivisionService {
    FacultyDivision getFacultyDivisionById(Long facultyDivisionId);
    List<FacultyDivision> getAllFacultyDivisions();
}
