package com.manage.faculty.dao;

import com.manage.student.entities.Student;

public interface Faculty_StudentDAO {
    Student getStudentById(Long studentId);
//    Student getStudentByUsername(String username);
//    Student getStudentByEmail(String email);
}
