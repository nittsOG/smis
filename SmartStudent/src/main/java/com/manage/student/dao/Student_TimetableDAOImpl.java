package com.manage.student.dao;

import com.manage.home.entities.Timetable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("studentTimetableDAOImpl")
@Transactional("studentTransactionManager")
public class Student_TimetableDAOImpl implements Student_TimetableDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_TimetableDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
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
