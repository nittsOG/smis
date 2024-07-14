package com.manage.manager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Course;

@Repository
@Transactional("managerTransactionManager")
public class Manager_CourseDAOImpl implements Manager_CourseDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_CourseDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Course getCourseById(Long courseId) {
        return sessionFactory.getCurrentSession().get(Course.class, courseId);
    }

    @Override
    public void saveCourse(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public void updateCourse(Course course) {
        sessionFactory.getCurrentSession().update(course);
    }

    @Override
    public void deleteCourse(Course course) {
        sessionFactory.getCurrentSession().delete(course);
    }
}
