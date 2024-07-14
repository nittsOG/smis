package com.manage.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.faculty.dao.Faculty_CourseDAO;
import com.manage.home.entities.Course;

@Service
@Transactional("facultyTransactionManager")
public class FacultyCourseServiceImpl implements FacultyCourseService {

    private final Faculty_CourseDAO facultyCourseDAO;

    @Autowired
    public FacultyCourseServiceImpl(@Qualifier("facultyCourseDAOImpl") Faculty_CourseDAO facultyCourseDAO) {
        this.facultyCourseDAO = facultyCourseDAO;
    }

    @Override
    public Course getCourseById(Long courseId) {
        return facultyCourseDAO.getCourseById(courseId);
    }

    @Override
    public void saveCourse(Course course) {
        facultyCourseDAO.saveCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        facultyCourseDAO.updateCourse(course);
    }

    @Override
    public void deleteCourse(Course course) {
        facultyCourseDAO.deleteCourse(course);
    }
}
