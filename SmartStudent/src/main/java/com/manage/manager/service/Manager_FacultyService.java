package com.manage.manager.service;

import com.manage.faculty.entities.Faculty;

public interface Manager_FacultyService {
    Faculty getFacultyById(Long facultyId);
    void saveFaculty(Faculty faculty);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(Faculty faculty);
}
