package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Course;
import com.manage.manager.dao.Manager_CourseDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_CourseServiceImpl implements Manager_CourseService {

    private final Manager_CourseDAO managerCourseDAO;

    @Autowired
    public Manager_CourseServiceImpl(Manager_CourseDAO managerCourseDAO) {
        this.managerCourseDAO = managerCourseDAO;
    }

    @Override
    public Course getCourseById(Long courseId) {
        return managerCourseDAO.getCourseById(courseId);
    }

    @Override
    public void saveCourse(Course course) {
        managerCourseDAO.saveCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        managerCourseDAO.updateCourse(course);
    }

    @Override
    public void deleteCourse(Course course) {
        managerCourseDAO.deleteCourse(course);
    }
}
