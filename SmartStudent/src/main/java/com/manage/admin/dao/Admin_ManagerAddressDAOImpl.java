package com.manage.admin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.manager.entities.ManagerAddress;

@Repository
@Qualifier("adminManagerAddressDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_ManagerAddressDAOImpl implements Admin_ManagerAddressDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public Admin_ManagerAddressDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public ManagerAddress getManagerAddressById(Long managerAddressId) {
		return sessionFactory.getCurrentSession().get(ManagerAddress.class, managerAddressId);
	}

	@Override
	public void saveManagerAddress(ManagerAddress managerAddress) {
		sessionFactory.getCurrentSession().save(managerAddress);
	}

	@Override
	public void updateManagerAddress(ManagerAddress managerAddress) {
		sessionFactory.getCurrentSession().update(managerAddress);
	}

	@Override
	public void deleteManagerAddress(ManagerAddress managerAddress) {
		sessionFactory.getCurrentSession().delete(managerAddress);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerAddress> getAllManagerAddresses() {
		return sessionFactory.getCurrentSession().createQuery("FROM ManagerAddress").list();
	}

	@Override
	public void deleteManagerAddressByManagerId(Long managerId) {
		String hql = "DELETE FROM ManagerAddress WHERE manager.managerId = :managerId";
		Query<?> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("managerId", managerId);
		query.executeUpdate();
	}

}
