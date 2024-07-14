package com.manage.manager.dao;

import com.manage.student.entities.Student;

public interface Manager_StudentDAO {
    Student getStudentById(Long studentId);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
}
