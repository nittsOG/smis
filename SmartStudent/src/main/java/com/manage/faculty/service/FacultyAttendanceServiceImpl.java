package com.manage.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.faculty.dao.Faculty_AttendanceDAO;
import com.manage.home.entities.Attendance;

@Service
@Transactional("facultyTransactionManager")
public class FacultyAttendanceServiceImpl implements FacultyAttendanceService {

    private final Faculty_AttendanceDAO facultyAttendanceDAO;

    @Autowired
    public FacultyAttendanceServiceImpl(@Qualifier("facultyAttendanceDAOImpl") Faculty_AttendanceDAO facultyAttendanceDAO) {
        this.facultyAttendanceDAO = facultyAttendanceDAO;
    }

    @Override
    public Attendance getAttendanceById(Long attendanceId) {
        return facultyAttendanceDAO.getAttendanceById(attendanceId);
    }

    @Override
    public void saveAttendance(Attendance attendance) {
        facultyAttendanceDAO.saveAttendance(attendance);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        facultyAttendanceDAO.updateAttendance(attendance);
    }

    @Override
    public void deleteAttendance(Attendance attendance) {
        facultyAttendanceDAO.deleteAttendance(attendance);
    }
}
