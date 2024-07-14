package com.manage.admin.dao;

import com.manage.faculty.entities.Faculty;

public interface Admin_FacultyDAO {
    Faculty getFacultyById(Long facultyId);
    void saveFaculty(Faculty faculty);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(Faculty faculty);
}
