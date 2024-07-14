package com.manage.manager.dao;

import com.manage.home.entities.Subject;

public interface Manager_SubjectDAO {
    Subject getSubjectById(Long subjectId);
    void saveSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Subject subject);
}
