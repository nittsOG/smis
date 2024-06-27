package com.manage.faculty.dao;

import com.manage.faculty.entities.Faculty;

public interface FacultyDAO {
    Faculty getFacultyByUsername(String username);
    Faculty getFacultyById(Long id);
}
