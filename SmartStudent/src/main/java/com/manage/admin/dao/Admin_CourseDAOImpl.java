package com.manage.admin.dao;

import com.manage.home.entities.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("adminCourseDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_CourseDAOImpl implements Admin_CourseDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Admin_CourseDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveCourse(Course course) {
        sessionFactory.getCurrentSession().saveOrUpdate(course);
    }

    @Override
    public void updateCourse(Course course) {
        sessionFactory.getCurrentSession().update(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = sessionFactory.getCurrentSession().byId(Course.class).load(courseId);
        sessionFactory.getCurrentSession().delete(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return sessionFactory.getCurrentSession().get(Course.class, courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return sessionFactory.getCurrentSession().createQuery("from Course", Course.class).list();
    }
}
