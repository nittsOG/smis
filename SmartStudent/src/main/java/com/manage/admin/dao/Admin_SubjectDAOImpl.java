package com.manage.admin.dao;

import com.manage.home.entities.Subject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("adminSubjectDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_SubjectDAOImpl implements Admin_SubjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Admin_SubjectDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveSubject(Subject subject) {
        sessionFactory.getCurrentSession().saveOrUpdate(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        sessionFactory.getCurrentSession().update(subject);
    }

    @Override
    public void deleteSubject(Long subjectId) {
        Subject subject = sessionFactory.getCurrentSession().byId(Subject.class).load(subjectId);
        sessionFactory.getCurrentSession().delete(subject);
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        return sessionFactory.getCurrentSession().get(Subject.class, subjectId);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return sessionFactory.getCurrentSession().createQuery("from Subject", Subject.class).list();
    }
}
