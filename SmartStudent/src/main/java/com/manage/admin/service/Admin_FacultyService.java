package com.manage.admin.service;

import com.manage.faculty.entities.Faculty;

public interface Admin_FacultyService {
    Faculty getFacultyById(Long facultyId);

    void saveFaculty(Faculty faculty);

    void updateFaculty(Faculty faculty);

    void deleteFaculty(Faculty faculty);
}
