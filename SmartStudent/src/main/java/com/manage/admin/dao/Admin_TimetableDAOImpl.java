package com.manage.admin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
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
}

