package com.manage.manager.dao;

import com.manage.student.entities.Backlog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("managerBacklogDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_BacklogDAOImpl implements Manager_BacklogDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_BacklogDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
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
    public void deleteBacklog(Long studentId, String subjectCode, Integer semester) {
        Backlog.IdClass id = new Backlog.IdClass(studentId, subjectCode, semester);
        Backlog backlog = sessionFactory.getCurrentSession().get(Backlog.class, id);
        sessionFactory.getCurrentSession().delete(backlog);
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
}
