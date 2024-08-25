package com.manage.student.service;

import java.util.Map;

import com.manage.home.entities.Attendance;

public interface StudentAttendanceService {
    Attendance findById(Long id);
    // Add more service methods if needed

	Map<String, Object> getAttendanceSummary(Long studentId, Long semesterId);
}
