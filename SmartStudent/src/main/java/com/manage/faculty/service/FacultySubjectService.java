package com.manage.faculty.service;

import java.util.List;

import com.manage.home.entities.Subject;

public interface FacultySubjectService {
    Subject getSubjectById(Long subjectId);
    void saveSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Subject subject);
	List<Subject> getSubjectsByFacultyId(Long facultyId);
}
