package com.manage.faculty.dao;

import java.util.List;

import com.manage.home.entities.Attendance;
import com.manage.home.entities.Session;

public interface Faculty_AttendanceDAO {
    Attendance getAttendanceById(Long attendanceId);
    void saveAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(Attendance attendance);
    List<Session> getSessionsByFacultyId(Long facultyId);
	List<Attendance> getAttendanceBySessionId(Long sessionId);
	void saveSession(Session session);
	List<Attendance> getAttendanceByDivisionAndSubject(Long divisionId, Long subjectId);
}
