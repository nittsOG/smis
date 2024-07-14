package com.manage.student.dao;
import com.manage.home.entities.Semester;

public interface Student_SemesterDao {
    Semester findById(Long id);
    // Add more read-only methods as needed
}
