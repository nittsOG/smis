package com.manage.manager.service;

import java.util.List;

import com.manage.faculty.entities.Faculty;

public interface Manager_FacultyService {
    Faculty getFacultyById(Long facultyId);
    void saveFaculty(Faculty faculty);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(Faculty faculty);
	void createFacultyById(Faculty faculty);
	void deleteFacultyById(Long facultyId);
	List<Faculty> getFacultyByDepartment(String department);
	List<Faculty> getAllFaculties();
}
