package com.manage.student.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import com.manage.student.entities.Student;

@Repository
@Qualifier("studentDAOImpl")
@Transactional("studentTransactionManager")
public class StudentDAOImpl implements StudentDAO {
    
    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDAOImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student getStudentById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);
        }
    }

    @Override
    public Student getStudentByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student WHERE username = :username", Student.class)
                          .setParameter("username", username)
                          .uniqueResult();
        }
    }

    @Override
    public Student getStudentByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student WHERE email = :email", Student.class)
                          .setParameter("email", email)
                          .uniqueResult();
        }
    }
}
