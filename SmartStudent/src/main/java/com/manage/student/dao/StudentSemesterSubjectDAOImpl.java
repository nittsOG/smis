package com.manage.student.dao;

import com.manage.student.entities.StudentSemesterSubject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentSemesterSubjectDAOImpl")
@Transactional("studentTransactionManager")
public class StudentSemesterSubjectDAOImpl implements StudentSemesterSubjectDAO {


    private SessionFactory sessionFactory;
    
    @Autowired
	public StudentSemesterSubjectDAOImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    @Override
    public StudentSemesterSubject getStudentSemesterSubjectById(Long studentSemesterSubjectId) {
        return sessionFactory.getCurrentSession().get(StudentSemesterSubject.class, studentSemesterSubjectId);
    }


}
