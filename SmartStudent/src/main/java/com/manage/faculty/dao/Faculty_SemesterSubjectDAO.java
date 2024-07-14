package com.manage.faculty.dao;

import com.manage.home.entities.SemesterSubject;

public interface Faculty_SemesterSubjectDAO {
    SemesterSubject getSemesterSubjectById(Long semesterSubjectId);
    void saveSemesterSubject(SemesterSubject semesterSubject);
    void updateSemesterSubject(SemesterSubject semesterSubject);
    void deleteSemesterSubject(SemesterSubject semesterSubject);
}
