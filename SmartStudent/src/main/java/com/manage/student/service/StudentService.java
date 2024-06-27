package com.manage.student.service;

import com.manage.student.entities.Student;

public interface StudentService {
    boolean validateStudent(Long id, String password);
    Student getStudentByUsername(String username);
    Student getStudentById(Long id);
//    Student getStudentByEmail(String email);
}
