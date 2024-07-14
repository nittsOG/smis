package com.manage.manager.dao;

import com.manage.student.entities.StudentSemester;

public interface Manager_StudentSemesterDAO {
    StudentSemester getStudentSemesterById(Long studentSemesterId);
    void saveStudentSemester(StudentSemester studentSemester);
    void updateStudentSemester(StudentSemester studentSemester);
    void deleteStudentSemester(StudentSemester studentSemester);
}
