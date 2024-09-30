package com.manage.manager.dao;

import java.util.List;

import com.manage.student.entities.Student;

public interface Manager_StudentDAO {
    Student getStudentById(Long studentId);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
	List<Student> getStudentsByDepartment(String departmentName);
	List<Student> getStudentsByDivision(String divisionName);
	List<Student> getAllStudents();
}
