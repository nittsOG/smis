package com.manage.student.service;

import java.util.List;

import com.manage.home.entities.Semester;
import com.manage.student.entities.StudentSemester;

public interface StudentSemesterService {
    Semester findById(Long id);
    // Add more service methods if needed

	List<StudentSemester> getSemestersByStudentId(Long studentId);
}
