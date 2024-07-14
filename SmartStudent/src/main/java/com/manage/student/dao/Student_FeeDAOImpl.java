package com.manage.student.dao;

import com.manage.student.entities.Fee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("studentFeeDAOImpl")
@Transactional("studentTransactionManager")
public class Student_FeeDAOImpl implements Student_FeeDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_FeeDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Fee getFeeById(Long feeId) {
        return sessionFactory.getCurrentSession().get(Fee.class, feeId);
    }

    @Override
    public List<Fee> getAllFees() {
        return sessionFactory.getCurrentSession().createQuery("from Fee", Fee.class).list();
    }
}
