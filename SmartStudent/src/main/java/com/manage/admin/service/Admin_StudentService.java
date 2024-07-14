package com.manage.admin.service;

import com.manage.student.entities.Student;

public interface Admin_StudentService {
    Student getStudentById(Long studentId);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long studentId);
}
