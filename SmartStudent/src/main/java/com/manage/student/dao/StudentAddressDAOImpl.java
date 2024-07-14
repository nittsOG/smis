package com.manage.student.dao;

import com.manage.student.entities.StudentAddress;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentAddressDAOImpl")
@Transactional("studentTransactionManager")
public class StudentAddressDAOImpl implements StudentAddressDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public StudentAddressDAOImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public StudentAddress getStudentAddressById(Long studentAddressId) {
        return sessionFactory.getCurrentSession().get(StudentAddress.class, studentAddressId);
    }

}
