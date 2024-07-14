package com.manage.manager.service;

import com.manage.home.entities.Course;

public interface Manager_CourseService {
    Course getCourseById(Long courseId);
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
}
