package com.manage.student.dao;

import com.manage.student.entities.Payment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("studentPaymentDAOImpl")
@Transactional("studentTransactionManager")
public class Student_PaymentDAOImpl implements Student_PaymentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_PaymentDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return sessionFactory.getCurrentSession().get(Payment.class, paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return sessionFactory.getCurrentSession().createQuery("from Payment", Payment.class).list();
    }
}
