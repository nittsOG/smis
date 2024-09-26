package com.manage.admin.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Course;
import com.manage.home.entities.Semester;

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
        Course oldcourse = this.getCourseById(course.getCourseId());

        // Manually initialize the lazy-loaded collection
        Hibernate.initialize(oldcourse.getSemesters());
        
        Set<Semester> existingSemesters = oldcourse.getSemesters();
        
        if (existingSemesters == null) {
            existingSemesters = new HashSet<>();
            oldcourse.setSemesters(existingSemesters);
        }

        Set<Semester> newSemesters = course.getSemesters();
        if (newSemesters != null) {
            existingSemesters.clear();
            existingSemesters.addAll(newSemesters);
        }
        
        oldcourse.setDepartment(course.getDepartment());
        oldcourse.setName(course.getName());
        oldcourse.setDescription(course.getDescription());

        sessionFactory.getCurrentSession().merge(oldcourse);
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
    
    @Override
    public List<Course> getCoursesByDepartment(Long departmentId) {
        return sessionFactory.getCurrentSession()
            .createQuery("from Course where department.id = :departmentId", Course.class)
            .setParameter("departmentId", departmentId)
            .list();
    }
    
    

}
