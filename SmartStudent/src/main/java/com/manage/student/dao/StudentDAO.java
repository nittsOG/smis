package com.manage.student.dao;

import com.manage.student.entities.Student;

public interface StudentDAO {
    Student getStudentByUsername(String username);
    Student getStudentById(Long id);
}
