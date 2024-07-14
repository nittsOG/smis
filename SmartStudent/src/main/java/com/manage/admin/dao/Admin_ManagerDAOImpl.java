package com.manage.admin.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.manager.entities.Manager;

@Repository
@Qualifier("adminManagerDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_ManagerDAOImpl implements Admin_ManagerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Admin_ManagerDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Manager getManagerById(Long managerId) {
        return sessionFactory.getCurrentSession().get(Manager.class, managerId);
    }

    @Override
    public void saveManager(Manager manager) {
        sessionFactory.getCurrentSession().save(manager);
    }

    @Override
    public void updateManager(Manager manager) {
        sessionFactory.getCurrentSession().update(manager);
    }

    @Override
    public void deleteManager(Manager manager) {
        sessionFactory.getCurrentSession().delete(manager);
    }
}
