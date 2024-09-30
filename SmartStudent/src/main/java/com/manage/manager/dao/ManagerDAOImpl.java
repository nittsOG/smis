package com.manage.manager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.manage.manager.entities.Manager;

@Repository
@Qualifier("managerDAOImpl")
@Transactional("managerTransactionManager")
public class ManagerDAOImpl implements ManagerDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public ManagerDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Manager getManagerByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Manager WHERE username = :username", Manager.class)
				.setParameter("username", username).uniqueResult();
	}

	@Override
	public Manager getManagerById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Manager.class, id);
	}
}
