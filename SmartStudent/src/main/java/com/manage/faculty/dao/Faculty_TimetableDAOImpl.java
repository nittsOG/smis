package com.manage.faculty.dao;

import com.manage.home.entities.Timetable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("facultyTimetableDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_TimetableDAOImpl implements Faculty_TimetableDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_TimetableDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
