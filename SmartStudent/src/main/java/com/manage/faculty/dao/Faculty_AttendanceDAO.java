package com.manage.faculty.dao;

import com.manage.home.entities.Attendance;

public interface Faculty_AttendanceDAO {
    Attendance getAttendanceById(Long attendanceId);
    void saveAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(Attendance attendance);
}
