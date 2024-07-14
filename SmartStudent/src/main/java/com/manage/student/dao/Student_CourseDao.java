package com.manage.student.dao;

import com.manage.home.entities.Course;

public interface Student_CourseDao {
    Course findById(Long id);
    // Add more read-only methods as needed
}
