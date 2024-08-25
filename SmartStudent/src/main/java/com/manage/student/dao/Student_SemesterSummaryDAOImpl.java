package com.manage.student.dao;

import com.manage.student.entities.SemesterSummary;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("studentSemesterSummaryDAOImpl")
@Transactional("studentTransactionManager")
public class Student_SemesterSummaryDAOImpl implements Student_SemesterSummaryDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_SemesterSummaryDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SemesterSummary getSemesterSummaryById(Integer studentId, Integer semester) {
        SemesterSummary.IdClass id = new SemesterSummary.IdClass(studentId, semester);
        return sessionFactory.getCurrentSession().get(SemesterSummary.class, id);
    }

    @Override
    public List<SemesterSummary> getAllSemesterSummaries() {
        return sessionFactory.getCurrentSession().createQuery("from SemesterSummary", SemesterSummary.class).list();
    }

    @Override
    public List<SemesterSummary> getSemesterSummariesByStudentId(Integer studentId) {
        return sessionFactory.getCurrentSession().createQuery("from SemesterSummary where studentId = :studentId", SemesterSummary.class)
                .setParameter("studentId", studentId).list();
    }
}
