package com.manage.faculty.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.StudentSemester;

@Repository
@Qualifier("facultyStudentSemesterDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_StudentSemesterDAOImpl implements Faculty_StudentSemesterDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_StudentSemesterDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public StudentSemester getStudentSemesterById(Long studentSemesterId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(StudentSemester.class, studentSemesterId);
    }
}
