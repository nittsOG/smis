package com.manage.student.dao;

import com.manage.home.entities.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentSessionDaoImpl")
@Transactional("studentTransactionManager")
public class Student_SessionDaoImpl implements Student_SessionDao {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_SessionDaoImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public Session findById(Long id) {
        return sessionFactory.getCurrentSession().get(Session.class, id);
    }

    // Implement more read-only methods as needed
}
