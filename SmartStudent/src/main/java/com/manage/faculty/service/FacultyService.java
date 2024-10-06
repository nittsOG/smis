package com.manage.faculty.service;

import com.manage.faculty.entities.Faculty;

public interface FacultyService {
    boolean validateFaculty(Long id, String password);
    Faculty getFacultyByUsername(String username);
    Faculty getFacultyById(Long id);
//    Faculty getFacultyByEmail(String email);
	void updateFaculty(Faculty faculty);
	void changePassword(Long id, String newPassword);
}
