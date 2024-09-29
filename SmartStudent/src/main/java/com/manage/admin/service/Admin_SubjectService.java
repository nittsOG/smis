package com.manage.admin.service;

import com.manage.home.entities.Subject;

import java.util.List;

public interface Admin_SubjectService {

    void saveSubject(Subject subject);

    void updateSubject(Subject subject);

    void deleteSubject(Long subjectId);

    Subject getSubjectById(Long subjectId);

    List<Subject> getAllSubjects();

	List<Subject> getSubjectsByCourse(Long courseId);
}
