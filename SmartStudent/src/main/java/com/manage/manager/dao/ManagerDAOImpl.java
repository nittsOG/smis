package com.manage.manager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.manage.manager.entities.Manager;

@Repository
public class ManagerDAOImpl implements ManagerDAO {
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public ManagerDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Manager getManagerByUsername(String username) {
        return sessionFactory.getCurrentSession().get(Manager.class, username);
    }
}
