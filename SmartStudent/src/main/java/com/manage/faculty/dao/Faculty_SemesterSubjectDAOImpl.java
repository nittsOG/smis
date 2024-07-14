package com.manage.faculty.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.SemesterSubject;

@Repository
@Qualifier("facultySemesterSubjectDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_SemesterSubjectDAOImpl implements Faculty_SemesterSubjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_SemesterSubjectDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
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
