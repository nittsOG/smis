package com.manage.student.dao;

import com.manage.home.entities.Semester;
import com.manage.student.entities.StudentSemester;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentSemesterDaoImpl")
@Transactional("studentTransactionManager")
public class Student_SemesterDaoImpl implements Student_SemesterDao {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_SemesterDaoImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public Semester findById(Long id) {
        return sessionFactory.getCurrentSession().get(Semester.class, id);
    }

	public List<StudentSemester> findSemestersByStudentId(Long studentId) {
	    Session session = sessionFactory.getCurrentSession();

	    String query = "SELECT ss FROM StudentSemester ss " +
	                   "JOIN FETCH ss.semester sem " +
	                   "JOIN ss.student s " +
	                   "WHERE s.studentId = :studentId";

	    List<StudentSemester> studentSemesterList = session.createQuery(query, StudentSemester.class)
	            .setParameter("studentId", studentId)
	            .getResultList();

	    return studentSemesterList;
	}


    // Implement more read-only methods as needed
}
