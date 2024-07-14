package com.manage.manager.service;

import com.manage.student.entities.StudentSemesterSubject;

public interface Manager_StudentSemesterSubjectService {
    StudentSemesterSubject getStudentSemesterSubjectById(Long studentSemesterSubjectId);
    void saveStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject);
    void updateStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject);
    void deleteStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject);
}
