package com.manage.faculty.dao;

import com.manage.faculty.entities.FacultySubject;
import java.util.List;

public interface Faculty_FacultySubjectDAO {
    FacultySubject getFacultySubjectById(Long facultySubjectId);
    List<FacultySubject> getAllFacultySubjects();
    void updateFacultySubject(FacultySubject facultySubject);
}
