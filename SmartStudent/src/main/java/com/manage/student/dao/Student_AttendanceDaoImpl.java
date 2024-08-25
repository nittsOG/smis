package com.manage.student.dao;

import com.manage.home.entities.Attendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("studentAttendanceDAOImpl")
@Transactional("studentTransactionManager")
public class Student_AttendanceDaoImpl implements Student_AttendanceDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public Student_AttendanceDaoImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Attendance findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Attendance.class, id);
    }

    @Override
    public List<Attendance> findAttendanceByStudentAndSemester(Long studentId, Long semesterId) {
        Session session = sessionFactory.getCurrentSession();

        String query = "SELECT a FROM Attendance a " +
                       "JOIN a.session s " +
                       "JOIN s.subject sub " +
                       "JOIN sub.semesterSubjects ss " +
                       "JOIN ss.semester sem " +
                       "WHERE a.student.studentId = :studentId AND sem.semesterId = :semesterId";

        List<Attendance> attendanceList = session.createQuery(query, Attendance.class)
                .setParameter("studentId", studentId)
                .setParameter("semesterId", semesterId)
                .getResultList();

        return attendanceList;
    }

    // Implement more read-only methods as needed
}
