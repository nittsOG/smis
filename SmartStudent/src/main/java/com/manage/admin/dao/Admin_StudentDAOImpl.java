package com.manage.admin.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.Student;

import java.util.List;

@Repository
@Qualifier("adminStudentDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_StudentDAOImpl implements Admin_StudentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Admin_StudentDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student getStudentById(Long studentId) {
        return sessionFactory.getCurrentSession().get(Student.class, studentId);
    }

    @Override
    public void saveStudent(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public void updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
    }

    @Override
    public void deleteStudent(Student student) {
        sessionFactory.getCurrentSession().delete(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return sessionFactory.getCurrentSession().createQuery("FROM Student", Student.class).getResultList();
    }
}
