package com.manage.admin.dao;

import java.util.List;

import com.manage.student.entities.Student;

public interface Admin_StudentDAO {
    Student getStudentById(Long studentId);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
	List<Student> getAllStudents();
}
