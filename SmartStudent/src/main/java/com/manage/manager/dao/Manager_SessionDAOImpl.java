package com.manage.manager.dao;

import com.manage.home.entities.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("managerSessionDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_SessionDAOImpl implements Manager_SessionDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_SessionDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveSession(Session session) {
        sessionFactory.getCurrentSession().saveOrUpdate(session);
    }

    @Override
    public void updateSession(Session session) {
        sessionFactory.getCurrentSession().update(session);
    }

    @Override
    public void deleteSession(Long sessionId) {
        Session session = sessionFactory.getCurrentSession().byId(Session.class).load(sessionId);
        sessionFactory.getCurrentSession().delete(session);
    }

    @Override
    public Session getSessionById(Long sessionId) {
        return sessionFactory.getCurrentSession().get(Session.class, sessionId);
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionFactory.getCurrentSession().createQuery("from Session", Session.class).list();
    }
    
    @Override
    public List<Session> getSessionsBySubject(Long subjectId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Session where subject.subjectId = :subjectId", Session.class)
                .setParameter("subjectId", subjectId)
                .list();
    }
}
