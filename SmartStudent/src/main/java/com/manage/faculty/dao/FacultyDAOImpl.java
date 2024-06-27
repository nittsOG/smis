package com.manage.faculty.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.manage.faculty.entities.Faculty;

@Repository
public class FacultyDAOImpl implements FacultyDAO {
    
    private final SessionFactory sessionFactory;
    
    @Autowired
    public FacultyDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Faculty getFacultyByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Faculty WHERE username = :username", Faculty.class)
                      .setParameter("username", username)
                      .uniqueResult();
    }

    @Override
    public Faculty getFacultyById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Faculty.class, id);
    }
}
