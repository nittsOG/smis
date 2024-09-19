package com.manage.faculty.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Session;

@Repository
@Qualifier("facultySessionDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_SessionDAOImpl implements Faculty_SessionDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_SessionDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session getSessionById(Long sessionId) {
        return sessionFactory.getCurrentSession().get(Session.class, sessionId);
    }

    @Override
    public void saveSession(Session session) {
        sessionFactory.getCurrentSession().save(session);
    }

    @Override
    public void updateSession(Session session) {
        sessionFactory.getCurrentSession().update(session);
    }

    @Override
    public void deleteSession(Session session) {
        sessionFactory.getCurrentSession().delete(session);
    }
    
    /////////////////////////
    
    @Override
    public List<Session> getSessionsByFacultySubjectDivision(Long facultyId, Long subjectId, Long divisionId) {
        String hql = "FROM Session s WHERE s.Faculty_Id = :facultyId AND s.subject.subjectId = :subjectId AND s.Division_Id = :divisionId";
        return sessionFactory.getCurrentSession()
            .createQuery(hql, Session.class)
            .setParameter("facultyId", facultyId)
            .setParameter("subjectId", subjectId)
            .setParameter("divisionId", divisionId)
            .getResultList();
    }


}
