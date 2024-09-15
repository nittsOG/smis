package com.manage.faculty.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.entities.FacultyAddress;


@Repository
@Qualifier("facultyAddressDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_AddressDAOImpl implements Faculty_AddressDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_AddressDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
    public FacultyAddress getAddressById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(FacultyAddress.class, id);
    }

    @Override
    public void saveAddress(FacultyAddress address) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(address);
    }

    @Override
    public void deleteAddress(int id) {
        Session session = sessionFactory.getCurrentSession();
        FacultyAddress address = session.get(FacultyAddress.class, id);
        if (address != null) {
            session.delete(address);
        }
    }
}
