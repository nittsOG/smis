package com.manage.admin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Timetable;


@Repository
@Qualifier("adminTimetableDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_TimetableDAOImpl implements Admin_TimetableDAO {

    private SessionFactory sessionFactory;
    
    @Autowired
    public Admin_TimetableDAOImpl(@Qualifier("adminSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Timetable timetable) {
        sessionFactory.getCurrentSession().save(timetable);
    }

    public void update(Timetable timetable) {
        sessionFactory.getCurrentSession().update(timetable);
    }

    public void delete(Timetable timetable) {
        sessionFactory.getCurrentSession().delete(timetable);
    }

    public Timetable findById(Long id) {
        return sessionFactory.getCurrentSession().get(Timetable.class, id);
    }

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
