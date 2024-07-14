package com.manage.manager.service;

import com.manage.home.entities.Subject;

public interface Manager_SubjectService {
    Subject getSubjectById(Long subjectId);
    void saveSubject(Subject subject);
    void updateSubject(Subject subject);
    void deleteSubject(Subject subject);
}
