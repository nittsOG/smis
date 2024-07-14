package com.manage.admin.dao;

import com.manage.home.entities.Subject;

import java.util.List;

public interface Admin_SubjectDAO {
    void saveSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Long subjectId);
    Subject getSubjectById(Long subjectId);
    List<Subject> getAllSubjects();
}
