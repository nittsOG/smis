package com.manage.manager.service;

import com.manage.home.entities.Semester;

public interface Manager_SemesterService {
    Semester getSemesterById(Long semesterId);
    void saveSemester(Semester semester);
    void updateSemester(Semester semester);
    void deleteSemester(Semester semester);
}
