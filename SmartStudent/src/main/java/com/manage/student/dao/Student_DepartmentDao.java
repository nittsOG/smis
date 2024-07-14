package com.manage.student.dao;

import com.manage.home.entities.Department;

public interface Student_DepartmentDao {
    Department findById(Long id);
    // Add more read-only methods as needed
}
