package com.manage.admin.service;

import java.util.List;

import com.manage.student.entities.Student;

public interface Admin_StudentService {
    Student getStudentById(Long studentId);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long studentId);

	List<Student> getAllStudents();
}
