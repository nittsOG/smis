package com.manage.student.dao;

import com.manage.home.entities.Subject;

public interface Student_SubjectDao {
    Subject findById(Long id);
    // Add more read-only methods as needed
}
