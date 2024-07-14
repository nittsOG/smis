package com.manage.student.dao;

import com.manage.home.entities.Session;

public interface Student_SessionDao {
    Session findById(Long id);
    // Add more read-only methods as needed
}
