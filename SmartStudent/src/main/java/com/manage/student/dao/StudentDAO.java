package com.manage.student.dao;

import com.manage.student.entities.Student;

public interface StudentDAO {
    Student getStudentById(Long id);

	void updateStudent(Student student);
}
