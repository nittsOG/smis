package com.manage.student.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.manage.student.entities.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
    
    private final SessionFactory sessionFactory;
    
    @Autowired
    public StudentDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student getStudentByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student WHERE username = :username", Student.class)
                      .setParameter("username", username)
                      .uniqueResult();
    }

    @Override
    public Student getStudentById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }
}
