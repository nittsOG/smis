package com.manage.faculty.dao;

import com.manage.home.entities.Subject;

public interface Faculty_SubjectDAO {
    Subject getSubjectById(Long subjectId);
    void saveSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Subject subject);
}
