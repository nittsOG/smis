package com.manage.faculty.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Subject;

@Repository
@Qualifier("facultySubjectDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_SubjectDAOImpl implements Faculty_SubjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_SubjectDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        return sessionFactory.getCurrentSession().get(Subject.class, subjectId);
    }

    @Override
    public void saveSubject(Subject subject) {
        sessionFactory.getCurrentSession().save(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        sessionFactory.getCurrentSession().update(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        sessionFactory.getCurrentSession().delete(subject);
    }
}
