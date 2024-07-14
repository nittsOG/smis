package com.manage.admin.service;

import com.manage.home.entities.SemesterSubject;

import java.util.List;

public interface Admin_SemesterSubjectService {
    void saveSemesterSubject(SemesterSubject semesterSubject);

    void updateSemesterSubject(SemesterSubject semesterSubject);

    void deleteSemesterSubject(Long semesterSubjectId);

    SemesterSubject getSemesterSubjectById(Long semesterSubjectId);

    List<SemesterSubject> getAllSemesterSubjects();
}
