package com.manage.admin.dao;

import java.util.List;

import com.manage.student.entities.StudentSemesterSubject;

public interface Admin_StudentSemesterSubjectDAO {
    StudentSemesterSubject getStudentSemesterSubjectById(Long studentSemesterSubjectId);
    void saveStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject);
    void updateStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject);
    void deleteStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject);
	List<StudentSemesterSubject> getAllStudentSemesterSubjects();
	List<StudentSemesterSubject> getStudentSemesterSubjectsByStudentId(Long studentId);
}
