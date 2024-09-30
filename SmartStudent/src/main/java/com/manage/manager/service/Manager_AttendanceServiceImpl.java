package com.manage.manager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.manager.dao.Manager_AttendanceDAO;
import com.manage.home.entities.Attendance;

@Service
@Qualifier("managerAttendanceServiceImpl")
public class Manager_AttendanceServiceImpl implements Manager_AttendanceService {

    private final Manager_AttendanceDAO managerAttendanceDAO;

    @Autowired
    public Manager_AttendanceServiceImpl(@Qualifier("managerAttendanceDAOImpl") Manager_AttendanceDAO managerAttendanceDAO) {
        this.managerAttendanceDAO = managerAttendanceDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveAttendance(Attendance attendance) {
        managerAttendanceDAO.saveAttendance(attendance);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateAttendance(Attendance attendance) {
        managerAttendanceDAO.updateAttendance(attendance);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteAttendance(Long attendanceId) {
        managerAttendanceDAO.deleteAttendance(attendanceId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Attendance getAttendanceById(Long attendanceId) {
        return managerAttendanceDAO.getAttendanceById(attendanceId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Attendance> getAllAttendances() {
        return managerAttendanceDAO.getAllAttendances();
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Attendance> getFilteredAttendances(Long studentId, Long divisionId, Long subjectId, Date date) {
        return managerAttendanceDAO.getFilteredAttendances(studentId, divisionId, subjectId, date);
    }

	@Override
	public void deleteAttendance(Attendance attendance) {
		managerAttendanceDAO.deleteAttendance(attendance);
	}
}
