package com.manage.admin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.manage.admin.entities.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AdminDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Admin.class, username);
    }
}
