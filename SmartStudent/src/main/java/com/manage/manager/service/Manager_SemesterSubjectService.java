package com.manage.manager.service;

import com.manage.home.entities.SemesterSubject;

public interface Manager_SemesterSubjectService {
    SemesterSubject getSemesterSubjectById(Long semesterSubjectId);
    void saveSemesterSubject(SemesterSubject semesterSubject);
    void updateSemesterSubject(SemesterSubject semesterSubject);
    void deleteSemesterSubject(SemesterSubject semesterSubject);
}
