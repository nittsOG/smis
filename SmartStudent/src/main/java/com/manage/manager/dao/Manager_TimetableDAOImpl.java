package com.manage.manager.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.manage.home.entities.Timetable;

@Repository
@Qualifier("managerTimetableDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_TimetableDAOImpl implements Manager_TimetableDAO {

    private SessionFactory sessionFactory;

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
}
