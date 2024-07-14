package com.manage.faculty.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.StudentSemesterSubject;

@Repository
@Qualifier("facultyStudentSemesterSubjectDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_StudentSemesterSubjectDAOImpl implements Faculty_StudentSemesterSubjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_StudentSemesterSubjectDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public StudentSemesterSubject getStudentSemesterSubjectById(Long studentSemesterSubjectId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(StudentSemesterSubject.class, studentSemesterSubjectId);
    }
}
