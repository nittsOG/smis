package com.manage.admin.service;

import com.manage.home.entities.Attendance;

import java.util.List;

public interface Admin_AttendanceService {
    void saveAttendance(Attendance attendance);

    void updateAttendance(Attendance attendance);

    void deleteAttendance(Long attendanceId);

    Attendance getAttendanceById(Long attendanceId);

    List<Attendance> getAllAttendances();
}
