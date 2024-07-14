package com.manage.faculty.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Attendance;

@Repository
@Qualifier("facultyAttendanceDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_AttendanceDAOImpl implements Faculty_AttendanceDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_AttendanceDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Attendance getAttendanceById(Long attendanceId) {
        return sessionFactory.getCurrentSession().get(Attendance.class, attendanceId);
    }

    @Override
    public void saveAttendance(Attendance attendance) {
        sessionFactory.getCurrentSession().save(attendance);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        sessionFactory.getCurrentSession().update(attendance);
    }

    @Override
    public void deleteAttendance(Attendance attendance) {
        sessionFactory.getCurrentSession().delete(attendance);
    }
}
