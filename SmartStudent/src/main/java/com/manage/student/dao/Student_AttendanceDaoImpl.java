package com.manage.student.dao;

import com.manage.home.entities.Attendance;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentAttendanceDAOImpl")
@Transactional("studentTransactionManager")
public class Student_AttendanceDaoImpl implements Student_AttendanceDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public Student_AttendanceDaoImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Attendance findById(Long id) {
        return sessionFactory.getCurrentSession().get(Attendance.class, id);
    }

    // Implement more read-only methods as needed
}
