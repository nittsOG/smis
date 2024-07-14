package com.manage.faculty.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.Student;

@Repository
@Qualifier("facultyStudentDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_StudentDAOImpl implements Faculty_StudentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_StudentDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student getStudentById(Long studentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, studentId);
    }

//    @Override
//    public Student getStudentByUsername(String username) {
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
//        Root<Student> root = cq.from(Student.class);
//        cq.select(root).where(cb.equal(root.get("username"), username));
//        return session.createQuery(cq).uniqueResult();
//    }
//
//    @Override
//    public Student getStudentByEmail(String email) {
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
//        Root<Student> root = cq.from(Student.class);
//        cq.select(root).where(cb.equal(root.get("email"), email));
//        return session.createQuery(cq).uniqueResult();
//    }
}
