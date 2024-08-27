package com.manage.student.dao;

import com.manage.home.entities.Division;
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

    @Override
    public List<Timetable> getTimetableByDivision(Division division) {
        String hql = "FROM Timetable WHERE division = :division ORDER BY dayOfWeek, startTime";
        return sessionFactory.getCurrentSession()
            .createQuery(hql, Timetable.class)
            .setParameter("division", division)
            .getResultList();
    }
}
