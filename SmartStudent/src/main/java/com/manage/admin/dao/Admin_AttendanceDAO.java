package com.manage.admin.dao;

import com.manage.home.entities.Attendance;

import java.util.Date;
import java.util.List;

public interface Admin_AttendanceDAO {
	void saveAttendance(Attendance attendance);

	void updateAttendance(Attendance attendance);

	void deleteAttendance(Long attendanceId);

	Attendance getAttendanceById(Long attendanceId);

	List<Attendance> getAllAttendances();

	List<Attendance> getFilteredAttendances(Long studentId, Long divisionId, Long subjectId, Date date);
}
