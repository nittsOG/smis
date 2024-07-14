package com.manage.admin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Division;

@Repository
@Qualifier("adminDivisionDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_DivisionDAOImpl implements Admin_DivisionDAO{

    private SessionFactory sessionFactory;
    
    @Autowired
    public Admin_DivisionDAOImpl(@Qualifier("adminSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Division division) {
        sessionFactory.getCurrentSession().save(division);
    }

    public void update(Division division) {
        sessionFactory.getCurrentSession().update(division);
    }

    public void delete(Division division) {
        sessionFactory.getCurrentSession().delete(division);
    }

    public Division findById(Long id) {
        return sessionFactory.getCurrentSession().get(Division.class, id);
    }

    public List<Division> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Division", Division.class).list();
    }
}
