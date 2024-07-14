package com.manage.manager.dao;

import com.manage.home.entities.Attendance;

public interface Manager_AttendanceDAO {
    Attendance getAttendanceById(Long attendanceId);
    void saveAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(Attendance attendance);
}
