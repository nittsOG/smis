package com.manage.manager.service;

import java.util.List;

import com.manage.student.entities.StudentSemester;

public interface Manager_StudentSemesterService {
    StudentSemester getStudentSemesterById(Long studentSemesterId);
    void saveStudentSemester(StudentSemester studentSemester);
    void updateStudentSemester(StudentSemester studentSemester);
    void deleteStudentSemester(StudentSemester studentSemester);
	List<StudentSemester> getStudentSemestersByStudentId(Long studentId);
	List<StudentSemester> getAllStudentSemesters();
	void deleteStudentSemester(Long studentSemesterId);
}
