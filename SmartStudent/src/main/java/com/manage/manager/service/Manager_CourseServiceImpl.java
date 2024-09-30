package com.manage.manager.service;

import com.manage.manager.dao.Manager_CourseDAO;
import com.manage.home.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerCourseServiceImpl")
public class Manager_CourseServiceImpl implements Manager_CourseService {

    private final Manager_CourseDAO managerCourseDAO;

    @Autowired
    public Manager_CourseServiceImpl(@Qualifier("managerCourseDAOImpl") Manager_CourseDAO managerCourseDAO) {
        this.managerCourseDAO = managerCourseDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveCourse(Course course) {
        managerCourseDAO.saveCourse(course);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateCourse(Course course) {
        Course existingCourse = this.getCourseById(course.getCourseId());
        if (existingCourse != null) {
            managerCourseDAO.updateCourse(course);
        }
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteCourse(Long courseId) {
        managerCourseDAO.deleteCourse(courseId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Course getCourseById(Long courseId) {
        return managerCourseDAO.getCourseById(courseId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Course> getAllCourses() {
        return managerCourseDAO.getAllCourses();
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Course> getCoursesByDepartment(Long departmentId) {
        return managerCourseDAO.getCoursesByDepartment(departmentId);
    }

	@Override
	public void deleteCourse(Course course) {
		managerCourseDAO.deleteCourse(course);
	}
}
