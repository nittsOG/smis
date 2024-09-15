package com.manage.faculty.dao;

import com.manage.faculty.entities.Faculty;
import com.manage.faculty.entities.FacultyAddress;

public interface FacultyDAO {
    Faculty getFacultyByUsername(String username);
    Faculty getFacultyById(Long id);
	void updateFaculty(Faculty faculty);
	void updateFacultyAddress(FacultyAddress facultyAddress);
}
