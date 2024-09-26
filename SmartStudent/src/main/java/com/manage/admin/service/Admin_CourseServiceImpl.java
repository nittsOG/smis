package com.manage.admin.service;

import com.manage.admin.dao.Admin_CourseDAO;
import com.manage.home.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminCourseServiceImpl")
public class Admin_CourseServiceImpl implements Admin_CourseService {

    private final Admin_CourseDAO adminCourseDAO;

    @Autowired
    public Admin_CourseServiceImpl(@Qualifier("adminCourseDAOImpl") Admin_CourseDAO adminCourseDAO) {
        this.adminCourseDAO = adminCourseDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveCourse(Course course) {
        adminCourseDAO.saveCourse(course);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateCourse(Course course) {
    	Course existingCourse = this.getCourseById(course.getCourseId());
    	if(existingCourse != null) {
            adminCourseDAO.updateCourse(course);
    	}
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteCourse(Long courseId) {
        adminCourseDAO.deleteCourse(courseId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Course getCourseById(Long courseId) {
        return adminCourseDAO.getCourseById(courseId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Course> getAllCourses() {
        return adminCourseDAO.getAllCourses();
    }
    
    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Course> getCoursesByDepartment(Long departmentId) {
        return adminCourseDAO.getCoursesByDepartment(departmentId);
    }

}
