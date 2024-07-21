package com.manage.admin.dao;

import com.manage.faculty.entities.Faculty;

import java.util.List;

public interface Admin_FacultyDAO {
    Faculty getFacultyById(Long facultyId);
    void saveFaculty(Faculty faculty);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(Faculty faculty);
    List<Faculty> getAllFaculties(); // New method to fetch all faculties
}
