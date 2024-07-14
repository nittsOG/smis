package com.manage.manager.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.manage.home.entities.Division;

@Repository
@Qualifier("managerDivisionDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_DivisionDAOImpl implements Manager_DivisionDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public Manager_DivisionDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Division division) {
		sessionFactory.getCurrentSession().save(division);
	}

	@Override
	public void update(Division division) {
		sessionFactory.getCurrentSession().update(division);
	}

	@Override
	public void delete(Division division) {
		sessionFactory.getCurrentSession().delete(division);
	}

	@Override
	public Division findById(Long id) {
		return sessionFactory.getCurrentSession().get(Division.class, id);
	}

	@Override
	public List<Division> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Division", Division.class).list();
	}
}
