package com.manage.admin.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Attendance;

@Repository
@Qualifier("adminAttendanceDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_AttendanceDAOImpl implements Admin_AttendanceDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public Admin_AttendanceDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveAttendance(Attendance attendance) {
		sessionFactory.getCurrentSession().saveOrUpdate(attendance);
	}

	@Override
	public void updateAttendance(Attendance attendance) {
		sessionFactory.getCurrentSession().update(attendance);
	}

	@Override
	public void deleteAttendance(Long attendanceId) {
		Attendance attendance = sessionFactory.getCurrentSession().byId(Attendance.class).load(attendanceId);
		sessionFactory.getCurrentSession().delete(attendance);
	}

	@Override
	public Attendance getAttendanceById(Long attendanceId) {
		return sessionFactory.getCurrentSession().get(Attendance.class, attendanceId);
	}

	@Override
	public List<Attendance> getAllAttendances() {
		return sessionFactory.getCurrentSession().createQuery("from Attendance", Attendance.class).list();
	}

	@Override
	public List<Attendance> getFilteredAttendances(Long studentId, Long divisionId, Long subjectId, Date date) {
		StringBuilder queryBuilder = new StringBuilder("from Attendance a where 1=1");

		if (studentId != null) {
			queryBuilder.append(" and a.student.id = :studentId");
		}
		if (divisionId != null) {
			queryBuilder.append(" and a.student.division.id = :divisionId");
		}
		if (subjectId != null) {
			queryBuilder.append(" and a.session.subject.id = :subjectId");
		}
		if (date != null) {
			queryBuilder.append(" and a.session.sessionDate = :date");
		}

		Query<Attendance> query = sessionFactory.getCurrentSession().createQuery(queryBuilder.toString(), Attendance.class);

		if (studentId != null) {
			query.setParameter("studentId", studentId);
		}
		if (divisionId != null) {
			query.setParameter("divisionId", divisionId);
		}
		if (subjectId != null) {
			query.setParameter("subjectId", subjectId);
		}
		if (date != null) {
			query.setParameter("date", date);
		}

		return query.list();
	}
}
