package com.manage.admin.service;

import com.manage.student.entities.Student;
import java.util.List;

public interface Admin_StudentService {
	// Existing methods
	Student getStudentById(Long studentId);

	void saveStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(Long studentId);

	List<Student> getAllStudents();

	List<Student> getStudentsByDivision(String divisionName);

	List<Student> getStudentsByDepartment(String departmentName); // New method

	void createStudent(Student student);

	void deleteStudentById(Long studentId);
}
