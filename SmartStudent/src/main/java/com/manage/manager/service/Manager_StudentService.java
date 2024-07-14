package com.manage.manager.service;

import com.manage.student.entities.Student;

public interface Manager_StudentService {
    Student getStudentById(Long studentId);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
}
