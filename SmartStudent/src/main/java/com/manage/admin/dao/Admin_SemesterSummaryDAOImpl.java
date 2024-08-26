package com.manage.admin.dao;

import com.manage.student.entities.SemesterSummary;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("adminSemesterSummaryDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_SemesterSummaryDAOImpl implements Admin_SemesterSummaryDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Admin_SemesterSummaryDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveSemesterSummary(SemesterSummary semesterSummary) {
        sessionFactory.getCurrentSession().saveOrUpdate(semesterSummary);
    }

    @Override
    public void updateSemesterSummary(SemesterSummary semesterSummary) {
        sessionFactory.getCurrentSession().update(semesterSummary);
    }

    @Override
    public void deleteSemesterSummary(Long studentId, Integer semester) {
        SemesterSummary.IdClass id = new SemesterSummary.IdClass(studentId, semester);
        SemesterSummary semesterSummary = sessionFactory.getCurrentSession().get(SemesterSummary.class, id);
        if (semesterSummary != null) {
            sessionFactory.getCurrentSession().delete(semesterSummary);
        }
    }

    @Override
    public SemesterSummary getSemesterSummaryById(Long studentId, Integer semester) {
        SemesterSummary.IdClass id = new SemesterSummary.IdClass(studentId, semester);
        return sessionFactory.getCurrentSession().get(SemesterSummary.class, id);
    }

    @Override
    public List<SemesterSummary> getAllSemesterSummaries() {
        return sessionFactory.getCurrentSession().createQuery("from SemesterSummary", SemesterSummary.class).list();
    }
}
