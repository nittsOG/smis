package com.manage.manager.dao;

import com.manage.student.entities.SemesterResults;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("managerSemesterResultsDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_SemesterResultsDAOImpl implements Manager_SemesterResultsDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Manager_SemesterResultsDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveSemesterResults(SemesterResults semesterResults) {
        sessionFactory.getCurrentSession().saveOrUpdate(semesterResults);
    }

    @Override
    public void updateSemesterResults(SemesterResults semesterResults) {
        sessionFactory.getCurrentSession().update(semesterResults);
    }

    @Override
    public void deleteSemesterResults(SemesterResults.IdClass id) {
        SemesterResults semesterResults = sessionFactory.getCurrentSession().get(SemesterResults.class, id);
        if (semesterResults != null) {
            sessionFactory.getCurrentSession().delete(semesterResults);
        }
    }

    @Override
    public SemesterResults getSemesterResultsById(SemesterResults.IdClass id) {
        return sessionFactory.getCurrentSession().get(SemesterResults.class, id);
    }

    @Override
    public List<SemesterResults> getAllSemesterResults() {
        return sessionFactory.getCurrentSession().createQuery("from SemesterResults", SemesterResults.class).list();
    }
}
