package com.manage.manager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Semester;

@Repository
@Transactional("managerTransactionManager")
public class Manager_SemesterDAOImpl implements Manager_SemesterDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_SemesterDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
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
