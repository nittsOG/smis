package com.manage.faculty.dao;

import java.util.List;

import com.manage.student.entities.Student;

public interface Faculty_StudentDAO {
    Student getStudentById(Long studentId);
//    Student getStudentByUsername(String username);
//    Student getStudentByEmail(String email);
    List<Student> getStudentsByDivision(Long divisionId);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);
	List<Student> getAllStudents();
	List<Student> getStudentsByDivisionName(String divisionName);
}
