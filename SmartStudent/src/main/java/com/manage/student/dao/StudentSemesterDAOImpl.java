package com.manage.student.dao;

import com.manage.student.entities.StudentSemester;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentSemesterDAOImpl")
@Transactional("studentTransactionManager")
public class StudentSemesterDAOImpl implements StudentSemesterDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public StudentSemesterDAOImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public StudentSemester getStudentSemesterById(Long studentSemesterId) {
        return sessionFactory.getCurrentSession().get(StudentSemester.class, studentSemesterId);
    }

}