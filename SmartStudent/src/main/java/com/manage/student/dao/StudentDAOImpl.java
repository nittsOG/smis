package com.manage.student.dao;

import com.manage.student.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentDAOImpl")
@Transactional("studentTransactionManager")
public class StudentDAOImpl implements StudentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Student.class, id);
	} 
}
