package com.manage.manager.service;

import com.manage.home.entities.Attendance;

public interface Manager_AttendanceService {
    Attendance getAttendanceById(Long attendanceId);
    void saveAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(Attendance attendance);
}
