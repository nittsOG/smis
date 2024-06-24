package com.manage.faculty.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.manage.faculty.entities.Faculty;

@Repository
public class FacultyDAOImpl implements FacultyDAO {
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public FacultyDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        super();
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Faculty getFacultyByUsername(String username) {
        return sessionFactory.getCurrentSession().get(Faculty.class, username);
    }
}
