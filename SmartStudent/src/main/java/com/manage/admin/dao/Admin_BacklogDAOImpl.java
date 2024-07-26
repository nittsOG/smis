package com.manage.admin.dao;

import com.manage.student.entities.Backlog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("adminBacklogDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_BacklogDAOImpl implements Admin_BacklogDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Admin_BacklogDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveBacklog(Backlog backlog) {
        sessionFactory.getCurrentSession().saveOrUpdate(backlog);
    }

    @Override
    public void updateBacklog(Backlog backlog) {
        sessionFactory.getCurrentSession().update(backlog);
    }

    @Override
    public void deleteBacklog(Integer studentId, String subjectCode, Integer semester) {
        Backlog.IdClass id = new Backlog.IdClass(studentId, subjectCode, semester);
        Backlog backlog = sessionFactory.getCurrentSession().get(Backlog.class, id);
        if (backlog != null) {
            sessionFactory.getCurrentSession().delete(backlog);
        }
    }

    @Override
    public Backlog getBacklogById(Integer studentId, String subjectCode, Integer semester) {
        Backlog.IdClass id = new Backlog.IdClass(studentId, subjectCode, semester);
        return sessionFactory.getCurrentSession().get(Backlog.class, id);
    }

    @Override
    public List<Backlog> getAllBacklogs() {
        return sessionFactory.getCurrentSession().createQuery("from Backlog", Backlog.class).list();
    }
}