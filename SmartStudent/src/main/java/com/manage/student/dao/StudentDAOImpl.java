package com.manage.student.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.manage.student.entities.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public StudentDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}



	@Override
    public Student getStudentByUsername(String username) {
        return sessionFactory.getCurrentSession().get(Student.class, username);
    }
}
