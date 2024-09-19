package com.manage.faculty.dao;

import java.util.List;
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

    private final SessionFactory sessionFactory;

    @Autowired
    public Faculty_StudentDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getStudentsByDivision(Long divisionId) {
        String hql = "FROM Student WHERE division.divisionId = :divisionId";
        return sessionFactory.getCurrentSession()
            .createQuery(hql, Student.class)
            .setParameter("divisionId", divisionId)
            .getResultList();
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
}
