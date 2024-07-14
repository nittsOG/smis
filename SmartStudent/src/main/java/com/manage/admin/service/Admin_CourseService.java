package com.manage.admin.service;

import com.manage.home.entities.Course;

import java.util.List;

public interface Admin_CourseService {
    void saveCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(Long courseId);

    Course getCourseById(Long courseId);

    List<Course> getAllCourses();
}
