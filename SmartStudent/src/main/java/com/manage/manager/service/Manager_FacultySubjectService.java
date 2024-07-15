package com.manage.manager.service;

import com.manage.faculty.entities.FacultySubject;
import java.util.List;

public interface Manager_FacultySubjectService {
    void saveFacultySubject(FacultySubject facultySubject);
    void updateFacultySubject(FacultySubject facultySubject);
    void deleteFacultySubject(Long facultySubjectId);
    FacultySubject getFacultySubjectById(Long facultySubjectId);
    List<FacultySubject> getAllFacultySubjects();
}
