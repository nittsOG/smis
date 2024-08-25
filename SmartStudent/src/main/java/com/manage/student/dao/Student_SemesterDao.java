package com.manage.student.dao;
import java.util.List;

import com.manage.home.entities.Semester;
import com.manage.student.entities.StudentSemester;

public interface Student_SemesterDao {
    Semester findById(Long id);
    // Add more read-only methods as needed

	List<StudentSemester> findSemestersByStudentId(Long studentId);
}
