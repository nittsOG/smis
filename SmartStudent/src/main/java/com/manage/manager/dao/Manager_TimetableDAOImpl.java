package com.manage.manager.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Timetable;

@Repository
@Qualifier("managerTimetableDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_TimetableDAOImpl implements Manager_TimetableDAO {

    private final SessionFactory sessionFactory;
    
    @Autowired
    public Manager_TimetableDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Timetable timetable) {
        sessionFactory.getCurrentSession().save(timetable);
    }

    @Override
    public void update(Timetable timetable) {
        sessionFactory.getCurrentSession().update(timetable);
    }

    @Override
    public void delete(Timetable timetable) {
        sessionFactory.getCurrentSession().delete(timetable);
    }

    @Override
    public Timetable findById(Long id) {
        return sessionFactory.getCurrentSession().get(Timetable.class, id);
    }

    @Override
    public List<Timetable> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Timetable", Timetable.class).list();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Timetable> findTimetablesByFilters(Long subjectId, Long facultyId, Long divisionId) {
        StringBuilder queryBuilder = new StringBuilder("from Timetable t where 1=1");
        
        if (subjectId != null) {
            queryBuilder.append(" and t.subject.id = :subjectId");
        }
        if (facultyId != null) {
            queryBuilder.append(" and t.faculty.id = :facultyId");
        }
        if (divisionId != null) {
            queryBuilder.append(" and t.division.id = :divisionId");
        }

        Query<Timetable> query = sessionFactory.getCurrentSession().createQuery(queryBuilder.toString(), Timetable.class);
        
        if (subjectId != null) {
            query.setParameter("subjectId", subjectId);
        }
        if (facultyId != null) {
            query.setParameter("facultyId", facultyId);
        }
        if (divisionId != null) {
            query.setParameter("divisionId", divisionId);
        }

        return query.list();
    }
}
