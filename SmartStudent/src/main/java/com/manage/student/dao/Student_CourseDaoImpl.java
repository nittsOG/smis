package com.manage.student.dao;

import com.manage.home.entities.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentCourseDaoImpl")
@Transactional("studentTransactionManager")
public class Student_CourseDaoImpl implements Student_CourseDao {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_CourseDaoImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public Course findById(Long id) {
        return sessionFactory.getCurrentSession().get(Course.class, id);
    }

    // Implement more read-only methods as needed
}
