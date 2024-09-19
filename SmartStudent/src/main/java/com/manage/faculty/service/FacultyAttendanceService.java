package com.manage.faculty.service;

import java.util.List;
import java.util.Map;

import com.manage.home.entities.Attendance;
import com.manage.home.entities.Session;

public interface FacultyAttendanceService {
    Attendance getAttendanceById(Long attendanceId);
    void saveAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(Attendance attendance);
	List<Session> getSessionsByFacultyId(Long facultyId);
	List<Attendance> getAttendanceBySessionId(Long sessionId);
	void saveSession(Session session);
	Map<Session, List<Attendance>> getSessionAttendanceMap(Long facultyId, Long divisionId, Long subjectId);
	void createSessionWithAttendance(Session session);
}
