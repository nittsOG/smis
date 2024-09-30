package com.manage.manager.service;

import java.util.List;

import com.manage.home.entities.Course;

public interface Manager_CourseService {
    Course getCourseById(Long courseId);
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
	List<Course> getCoursesByDepartment(Long departmentId);
	List<Course> getAllCourses();
	void deleteCourse(Long courseId);
}
