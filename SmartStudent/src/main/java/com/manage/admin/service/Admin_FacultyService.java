package com.manage.admin.service;

import java.util.List;

import com.manage.faculty.entities.Faculty;

public interface Admin_FacultyService {
	Faculty getFacultyById(Long facultyId);

	void saveFaculty(Faculty faculty);

	void updateFaculty(Faculty faculty);

	void deleteFaculty(Faculty faculty);

	List<Faculty> getAllFaculties();

	List<Faculty> getFacultyByDepartment(String department);

	void deleteFacultyById(Long facultyId);
	
	void createFacultyById(Faculty faculty);
}
