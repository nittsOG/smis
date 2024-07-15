package com.manage.student.dao;

import com.manage.faculty.entities.FacultySubject;
import java.util.List;

public interface Student_FacultySubjectDAO {
    FacultySubject getFacultySubjectById(Long facultySubjectId);
    List<FacultySubject> getAllFacultySubjects();
}
