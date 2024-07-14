package com.manage.manager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.StudentSemesterSubject;

@Repository
@Transactional("managerTransactionManager")
public class Manager_StudentSemesterSubjectDAOImpl implements Manager_StudentSemesterSubjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_StudentSemesterSubjectDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public StudentSemesterSubject getStudentSemesterSubjectById(Long studentSemesterSubjectId) {
        return sessionFactory.getCurrentSession().get(StudentSemesterSubject.class, studentSemesterSubjectId);
    }

    @Override
    public void saveStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        sessionFactory.getCurrentSession().save(studentSemesterSubject);
    }

    @Override
    public void updateStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        sessionFactory.getCurrentSession().update(studentSemesterSubject);
    }

    @Override
    public void deleteStudentSemesterSubject(StudentSemesterSubject studentSemesterSubject) {
        sessionFactory.getCurrentSession().delete(studentSemesterSubject);
    }
}
