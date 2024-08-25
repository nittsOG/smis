package com.manage.admin.dao;

import java.util.List;

import com.manage.student.entities.StudentSemester;

public interface Admin_StudentSemesterDAO {
    StudentSemester getStudentSemesterById(Long studentSemesterId);
    void saveStudentSemester(StudentSemester studentSemester);
    void updateStudentSemester(StudentSemester studentSemester);
    void deleteStudentSemester(StudentSemester studentSemester);
	List<StudentSemester> getAllStudentSemesters();
}
