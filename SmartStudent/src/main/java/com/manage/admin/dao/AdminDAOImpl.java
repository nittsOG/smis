package com.manage.admin.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manage.admin.entities.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Admin getAdminByUsername(String username) {
        return sessionFactory.getCurrentSession().get(Admin.class, username);
    }
}

