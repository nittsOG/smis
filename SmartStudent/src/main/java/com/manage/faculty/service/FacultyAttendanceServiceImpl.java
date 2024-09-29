package com.manage.faculty.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.manage.faculty.dao.Faculty_AttendanceDAO;
import com.manage.faculty.dao.Faculty_SessionDAO;
import com.manage.faculty.dao.Faculty_StudentDAO;
import com.manage.home.entities.Attendance;
import com.manage.home.entities.AttendanceStatus;
import com.manage.home.entities.Session;
import com.manage.student.entities.Student;

@Service
@Qualifier("facultyAttendanceServiceImpl")
public class FacultyAttendanceServiceImpl implements FacultyAttendanceService {

    private Faculty_AttendanceDAO facultyAttendanceDAO;
    private Faculty_SessionDAO faculty_SessionDAO;
    private Faculty_StudentDAO faculty_StudentDAO;

    @Autowired
    public FacultyAttendanceServiceImpl(@Qualifier("facultyAttendanceDAOImpl")Faculty_AttendanceDAO facultyAttendanceDAO,
    		@Qualifier("facultySessionDAOImpl")Faculty_SessionDAO faculty_SessionDAO , @Qualifier("facultyStudentDAOImpl") Faculty_StudentDAO faculty_StudentDAO) {
		super();
		this.facultyAttendanceDAO = facultyAttendanceDAO;
		this.faculty_SessionDAO = faculty_SessionDAO;
		this.faculty_StudentDAO=faculty_StudentDAO;
	}

    @Override
    public Attendance getAttendanceById(Long attendanceId) {
        return facultyAttendanceDAO.getAttendanceById(attendanceId);
    }


	@Override
    public void saveAttendance(Attendance attendance) {
        facultyAttendanceDAO.saveAttendance(attendance);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        facultyAttendanceDAO.updateAttendance(attendance);
    }

    @Override
    public void deleteAttendance(Attendance attendance) {
        facultyAttendanceDAO.deleteAttendance(attendance);
    }

    @Override
    public List<Session> getSessionsByFacultyId(Long facultyId) {
        return facultyAttendanceDAO.getSessionsByFacultyId(facultyId);
    }

    @Override
    public List<Attendance> getAttendanceBySessionId(Long sessionId) {
        return facultyAttendanceDAO.getAttendanceBySessionId(sessionId);
    }

    @Override
    public void saveSession(Session session) {
        // Assuming you want to delegate session management to DAO
        facultyAttendanceDAO.saveSession(session);
    }
    
    //////////////////////
    
    @Override
    public Map<Session, List<Attendance>> getSessionAttendanceMap(Long facultyId, Long divisionId, Long subjectId) {
        List<Session> sessions = faculty_SessionDAO.getSessionsByFacultySubjectDivision(facultyId, subjectId, divisionId);
        Map<Session, List<Attendance>> sessionAttendanceMap = new HashMap<>();
        
        for (Session session : sessions) {
            List<Attendance> attendanceList = facultyAttendanceDAO.getAttendanceBySessionId(session.getSessionId());
            sessionAttendanceMap.put(session, attendanceList);
        }
        
        return sessionAttendanceMap;
    }

    
    @Override
    public void createSessionWithAttendance(Session session) {
        // Step 1: Save the session first
        faculty_SessionDAO.saveSession(session);

        // Step 2: Fetch all students for the given division
        List<Student> students = faculty_StudentDAO.getStudentsByDivision(session.getDivision_Id());

        // Step 3: For each student, create a new attendance entry and mark as 'ABSENT' by default
        for (Student student : students) {
            Attendance attendance = new Attendance();
            attendance.setSession(session);  // Set the session reference
            attendance.setStudent(student);  // Set the student reference
            attendance.setStatus(AttendanceStatus.ABSENT);  // Set default status to ABSENT

            // Save the attendance record
            facultyAttendanceDAO.saveAttendance(attendance);
        }
    }


}
