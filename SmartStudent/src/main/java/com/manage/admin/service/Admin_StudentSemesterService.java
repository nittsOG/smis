package com.manage.admin.service;

import com.manage.student.entities.StudentSemester;

public interface Admin_StudentSemesterService {
    StudentSemester getStudentSemesterById(Long studentSemesterId);

    void saveStudentSemester(StudentSemester studentSemester);

    void updateStudentSemester(StudentSemester studentSemester);

    void deleteStudentSemester(Long studentSemesterId);
}
