package com.manage.faculty.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Semester;

@Repository
@Qualifier("facultySemesterDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_SemesterDAOImpl implements Faculty_SemesterDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_SemesterDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Semester getSemesterById(Long semesterId) {
        return sessionFactory.getCurrentSession().get(Semester.class, semesterId);
    }

    @Override
    public void saveSemester(Semester semester) {
        sessionFactory.getCurrentSession().save(semester);
    }

    @Override
    public void updateSemester(Semester semester) {
        sessionFactory.getCurrentSession().update(semester);
    }

    @Override
    public void deleteSemester(Semester semester) {
        sessionFactory.getCurrentSession().delete(semester);
    }
}
