package com.manage.admin.service;

import com.manage.admin.dao.Admin_AttendanceDAO;
import com.manage.home.entities.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminAttendanceServiceImpl")
public class Admin_AttendanceServiceImpl implements Admin_AttendanceService {

    private final Admin_AttendanceDAO adminAttendanceDAO;

    @Autowired
    public Admin_AttendanceServiceImpl(@Qualifier("adminAttendanceDAOImpl") Admin_AttendanceDAO adminAttendanceDAO) {
        this.adminAttendanceDAO = adminAttendanceDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveAttendance(Attendance attendance) {
        adminAttendanceDAO.saveAttendance(attendance);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateAttendance(Attendance attendance) {
        adminAttendanceDAO.updateAttendance(attendance);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteAttendance(Long attendanceId) {
        adminAttendanceDAO.deleteAttendance(attendanceId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Attendance getAttendanceById(Long attendanceId) {
        return adminAttendanceDAO.getAttendanceById(attendanceId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Attendance> getAllAttendances() {
        return adminAttendanceDAO.getAllAttendances();
    }
}
