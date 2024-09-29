package com.manage.admin.dao;

import com.manage.student.entities.Student;
import java.util.List;

public interface Admin_StudentDAO {
    // Existing methods
    Student getStudentById(Long studentId);
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
    List<Student> getAllStudents();
    List<Student> getStudentsByDivision(String divisionName);
    List<Student> getStudentsByDepartment(String departmentName); // New method
	void createStudent(Student student);
}
