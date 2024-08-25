package com.manage.student.dao;

import com.manage.student.entities.SemesterResults;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("studentSemesterResultsDAOImpl")
@Transactional("studentTransactionManager")
public class Student_SemesterResultsDAOImpl implements Student_SemesterResultsDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_SemesterResultsDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SemesterResults getSemesterResultsById(SemesterResults.IdClass id) {
        return sessionFactory.getCurrentSession().get(SemesterResults.class, id);
    }

    @Override
    public List<SemesterResults> getAllSemesterResults() {
        return sessionFactory.getCurrentSession().createQuery("from SemesterResults", SemesterResults.class).list();
    }

    @Override
    public List<SemesterResults> getSemesterResultsByStudentId(Integer studentId) {
        return sessionFactory.getCurrentSession().createQuery("from SemesterResults where studentId = :studentId", SemesterResults.class)
                .setParameter("studentId", studentId).list();
    }
}
