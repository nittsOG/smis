package com.manage.student.service;

import com.manage.faculty.entities.FacultySubject;
import java.util.List;

public interface Student_FacultySubjectService {
    FacultySubject getFacultySubjectById(Long facultySubjectId);
    List<FacultySubject> getAllFacultySubjects();
}
