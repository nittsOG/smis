package com.manage.admin.dao;

import com.manage.home.entities.Attendance;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("adminAttendanceDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_AttendanceDAOImpl implements Admin_AttendanceDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Admin_AttendanceDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveAttendance(Attendance attendance) {
        sessionFactory.getCurrentSession().saveOrUpdate(attendance);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        sessionFactory.getCurrentSession().update(attendance);
    }

    @Override
    public void deleteAttendance(Long attendanceId) {
        Attendance attendance = sessionFactory.getCurrentSession().byId(Attendance.class).load(attendanceId);
        sessionFactory.getCurrentSession().delete(attendance);
    }

    @Override
    public Attendance getAttendanceById(Long attendanceId) {
        return sessionFactory.getCurrentSession().get(Attendance.class, attendanceId);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return sessionFactory.getCurrentSession().createQuery("from Attendance", Attendance.class).list();
    }
}
