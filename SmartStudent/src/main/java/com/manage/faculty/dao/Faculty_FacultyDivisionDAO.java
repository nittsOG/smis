package com.manage.faculty.dao;

import java.util.List;

import com.manage.faculty.entities.FacultyDivision;
import com.manage.home.entities.Division;

public interface Faculty_FacultyDivisionDAO {
    FacultyDivision getFacultyDivisionById(Long facultyDivisionId);
    List<FacultyDivision> getAllFacultyDivisions();
    void updateFacultyDivision(FacultyDivision facultyDivision);
	List<Division> getAllFacultyDivisions(Long facultyId);
}
