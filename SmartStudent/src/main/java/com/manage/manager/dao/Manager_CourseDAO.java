package com.manage.manager.dao;

import com.manage.home.entities.Course;

public interface Manager_CourseDAO {
    Course getCourseById(Long courseId);
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
}
