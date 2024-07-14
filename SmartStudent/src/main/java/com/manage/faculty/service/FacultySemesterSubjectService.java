package com.manage.faculty.service;

import com.manage.home.entities.SemesterSubject;

public interface FacultySemesterSubjectService {
    SemesterSubject getSemesterSubjectById(Long semesterSubjectId);
    void saveSemesterSubject(SemesterSubject semesterSubject);
    void updateSemesterSubject(SemesterSubject semesterSubject);
    void deleteSemesterSubject(SemesterSubject semesterSubject);
}
