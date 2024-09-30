package com.manage.manager.dao;

import java.util.List;

import com.manage.faculty.entities.Faculty;

public interface Manager_FacultyDAO {
    Faculty getFacultyById(Long facultyId);
    void saveFaculty(Faculty faculty);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(Faculty faculty);
	List<Faculty> getAllFaculties();
	List<Faculty> getFacultyByDepartment(String department);
	void deleteFacultyById(Long facultyId);
	void createFaculty(Faculty faculty);
}
