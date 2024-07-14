package com.manage.faculty.service;

import com.manage.home.entities.Attendance;

public interface FacultyAttendanceService {
    Attendance getAttendanceById(Long attendanceId);
    void saveAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(Attendance attendance);
}
