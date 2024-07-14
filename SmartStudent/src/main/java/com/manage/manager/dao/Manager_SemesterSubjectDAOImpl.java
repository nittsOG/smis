package com.manage.manager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.SemesterSubject;

@Repository
@Transactional("managerTransactionManager")
public class Manager_SemesterSubjectDAOImpl implements Manager_SemesterSubjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_SemesterSubjectDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SemesterSubject getSemesterSubjectById(Long semesterSubjectId) {
        return sessionFactory.getCurrentSession().get(SemesterSubject.class, semesterSubjectId);
    }

    @Override
    public void saveSemesterSubject(SemesterSubject semesterSubject) {
        sessionFactory.getCurrentSession().save(semesterSubject);
    }

    @Override
    public void updateSemesterSubject(SemesterSubject semesterSubject) {
        sessionFactory.getCurrentSession().update(semesterSubject);
    }

    @Override
    public void deleteSemesterSubject(SemesterSubject semesterSubject) {
        sessionFactory.getCurrentSession().delete(semesterSubject);
    }
}
