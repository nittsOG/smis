package com.manage.admin.dao;

import com.manage.faculty.entities.FacultySubject;
import java.util.List;

public interface Admin_FacultySubjectDAO {
    void saveFacultySubject(FacultySubject facultySubject);
    void updateFacultySubject(FacultySubject facultySubject);
    void deleteFacultySubject(Long facultySubjectId);
    FacultySubject getFacultySubjectById(Long facultySubjectId);
    List<FacultySubject> getAllFacultySubjects();
}
