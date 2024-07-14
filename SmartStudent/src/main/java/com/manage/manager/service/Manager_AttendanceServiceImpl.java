package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Attendance;
import com.manage.manager.dao.Manager_AttendanceDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_AttendanceServiceImpl implements Manager_AttendanceService {

    private final Manager_AttendanceDAO managerAttendanceDAO;

    @Autowired
    public Manager_AttendanceServiceImpl(Manager_AttendanceDAO managerAttendanceDAO) {
        this.managerAttendanceDAO = managerAttendanceDAO;
    }

    @Override
    public Attendance getAttendanceById(Long attendanceId) {
        return managerAttendanceDAO.getAttendanceById(attendanceId);
    }

    @Override
    public void saveAttendance(Attendance attendance) {
        managerAttendanceDAO.saveAttendance(attendance);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        managerAttendanceDAO.updateAttendance(attendance);
    }

    @Override
    public void deleteAttendance(Attendance attendance) {
        managerAttendanceDAO.deleteAttendance(attendance);
    }
}
