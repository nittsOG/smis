package com.manage.admin.service;

import java.util.List;

import com.manage.student.entities.StudentSemesterSubject;

public interface Admin_StudentSemesterSubjectService {
    StudentSemesterSubject getStudentSemesterSubjectById(Long studentSemesterSubjectId);

    void saveStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject);

    void updateStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject);

    void deleteStudentSemesterSubject(Long studentSemesterSubjectId);

	List<StudentSemesterSubject> getAllStudentSemesterSubjects();

	List<StudentSemesterSubject> getStudentSemesterSubjectsByStudentId(Long studentId);
}
