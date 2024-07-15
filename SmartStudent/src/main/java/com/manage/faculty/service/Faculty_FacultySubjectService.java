package com.manage.faculty.service;

import com.manage.faculty.entities.FacultySubject;
import java.util.List;

public interface Faculty_FacultySubjectService {
    void updateFacultySubject(FacultySubject facultySubject);
    FacultySubject getFacultySubjectById(Long facultySubjectId);
    List<FacultySubject> getAllFacultySubjects();
}
