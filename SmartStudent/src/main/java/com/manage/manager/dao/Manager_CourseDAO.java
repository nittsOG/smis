package com.manage.manager.dao;

import java.util.List;

import com.manage.home.entities.Course;

public interface Manager_CourseDAO {
    Course getCourseById(Long courseId);
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
	void deleteCourse(Long courseId);
	List<Course> getAllCourses();
	List<Course> getCoursesByDepartment(Long departmentId);
}
