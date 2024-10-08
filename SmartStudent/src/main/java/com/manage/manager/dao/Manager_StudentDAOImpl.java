package com.manage.manager.dao;

import com.manage.student.entities.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("managerStudentDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_StudentDAOImpl implements Manager_StudentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Manager_StudentDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
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

    @Override
    public List<Student> getStudentsByDivision(String divisionName) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Student WHERE division.name = :divisionName", Student.class)
                .setParameter("divisionName", divisionName)
                .getResultList();
    }

    @Override
    public List<Student> getStudentsByDepartment(String departmentName) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Student WHERE division.department.name = :departmentName", Student.class)
                .setParameter("departmentName", departmentName)
                .getResultList();
    }
}
