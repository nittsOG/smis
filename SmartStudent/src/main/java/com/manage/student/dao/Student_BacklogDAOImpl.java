package com.manage.student.dao;

import com.manage.student.entities.Backlog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("studentBacklogDAOImpl")
@Transactional("studentTransactionManager")
public class Student_BacklogDAOImpl implements Student_BacklogDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_BacklogDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Backlog getBacklogById(Long studentId, String subjectCode, Integer semester) {
        Backlog.IdClass id = new Backlog.IdClass(studentId, subjectCode, semester);
        return sessionFactory.getCurrentSession().get(Backlog.class, id);
    }

    @Override
    public List<Backlog> getAllBacklogs() {
        return sessionFactory.getCurrentSession().createQuery("from Backlog", Backlog.class).list();
    }

    @Override
    public List<Backlog> getBacklogsByStudentId(Integer studentId) {
        return sessionFactory.getCurrentSession().createQuery("from Backlog where studentId = :studentId", Backlog.class)
                .setParameter("studentId", studentId).list();
    }
}
