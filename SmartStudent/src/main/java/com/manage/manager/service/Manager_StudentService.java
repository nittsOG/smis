package com.manage.manager.service;

import java.util.List;

import com.manage.student.entities.Student;

public interface Manager_StudentService {
    Student getStudentById(Long studentId);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
	List<Student> getStudentsByDivision(String divisionName);
	List<Student> getAllStudents();
	void deleteStudent(Long studentId);
	List<Student> getStudentsByDepartment(String departmentName);
}
