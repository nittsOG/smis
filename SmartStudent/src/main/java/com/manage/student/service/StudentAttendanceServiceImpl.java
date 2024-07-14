package com.manage.student.service;

import com.manage.home.entities.Attendance;
import com.manage.student.dao.Student_AttendanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("studentAttendanceServiceImpl")
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    private final Student_AttendanceDao attendanceDao;

    @Autowired
    public StudentAttendanceServiceImpl(@Qualifier("studentAttendanceDAOImpl") Student_AttendanceDao attendanceDao) {
        this.attendanceDao = attendanceDao;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public Attendance findById(Long id) {
        return attendanceDao.findById(id);
    }

    // Implement more service methods if needed
}
