package com.manage.manager.dao;

import java.util.Date;
import java.util.List;

import com.manage.home.entities.Attendance;

public interface Manager_AttendanceDAO {
    Attendance getAttendanceById(Long attendanceId);
    void saveAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(Attendance attendance);
	void deleteAttendance(Long attendanceId);
	List<Attendance> getAllAttendances();
	List<Attendance> getFilteredAttendances(Long studentId, Long divisionId, Long subjectId, Date date);
}
