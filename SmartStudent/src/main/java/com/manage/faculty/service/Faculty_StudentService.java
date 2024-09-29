package com.manage.faculty.service;

import java.util.List;
import com.manage.student.entities.Student;

public interface Faculty_StudentService {

    List<Student> getStudentsByDivision(Long divisionId);

    Student getStudentById(Long studentId);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

	List<Student> getAllStudents();

	List<Student> getStudentsByDivisionName(String divisionName);
}
