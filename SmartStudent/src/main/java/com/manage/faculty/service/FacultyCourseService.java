package com.manage.faculty.service;

import com.manage.home.entities.Course;

public interface FacultyCourseService {
    Course getCourseById(Long courseId);
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
}
