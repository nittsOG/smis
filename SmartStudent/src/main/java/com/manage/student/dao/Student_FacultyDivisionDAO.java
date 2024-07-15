package com.manage.student.dao;

import com.manage.faculty.entities.FacultyDivision;
import java.util.List;

public interface Student_FacultyDivisionDAO {
    FacultyDivision getFacultyDivisionById(Long facultyDivisionId);
    List<FacultyDivision> getAllFacultyDivisions();
}
