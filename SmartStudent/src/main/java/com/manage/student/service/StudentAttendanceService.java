package com.manage.student.service;

import com.manage.home.entities.Attendance;

public interface StudentAttendanceService {
    Attendance findById(Long id);
    // Add more service methods if needed
}
