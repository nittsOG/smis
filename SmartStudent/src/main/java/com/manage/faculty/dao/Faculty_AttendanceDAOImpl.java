package com.manage.faculty.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Attendance;
import com.manage.home.entities.Session;

@Repository
@Qualifier("facultyAttendanceDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_AttendanceDAOImpl implements Faculty_AttendanceDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public Faculty_AttendanceDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Attendance getAttendanceById(Long attendanceId) {
		return sessionFactory.getCurrentSession().get(Attendance.class, attendanceId);
	}

	@Override
	public void saveAttendance(Attendance attendance) {
		sessionFactory.getCurrentSession().save(attendance);
	}

	@Override
	public void updateAttendance(Attendance attendance) {
		sessionFactory.getCurrentSession().update(attendance);
	}

	@Override
	public void deleteAttendance(Attendance attendance) {
		sessionFactory.getCurrentSession().delete(attendance);
	}

	// New method to fetch attendance by session ID
	@Override
	public List<Session> getSessionsByFacultyId(Long facultyId) {
		String hql = "FROM Session s WHERE s.Faculty_Id = :facultyId";
		return sessionFactory.getCurrentSession().createQuery(hql, Session.class).setParameter("facultyId", facultyId)
				.getResultList();
	}

	@Override
	public List<Attendance> getAttendanceBySessionId(Long sessionId) {
		String hql = "FROM Attendance a JOIN FETCH a.student WHERE a.session.sessionId = :sessionId";
		return sessionFactory.getCurrentSession().createQuery(hql, Attendance.class)
				.setParameter("sessionId", sessionId).getResultList();
	}

	@Override
	public List<Attendance> getAttendanceByDivisionAndSubject(Long divisionId, Long subjectId) {
		String hql = "FROM Attendance a WHERE a.session.Division_Id = :divisionId AND a.session.subject.subjectId = :subjectId";
		return sessionFactory.getCurrentSession().createQuery(hql, Attendance.class)
				.setParameter("divisionId", divisionId).setParameter("subjectId", subjectId).getResultList();
	}

	@Override
	public void saveSession(Session session) {
		sessionFactory.getCurrentSession().save(session);
	}
}
