package com.manage.faculty.service;

import com.manage.home.entities.Semester;

public interface FacultySemesterService {
    Semester getSemesterById(Long semesterId);
    void saveSemester(Semester semester);
    void updateSemester(Semester semester);
    void deleteSemester(Semester semester);
}
