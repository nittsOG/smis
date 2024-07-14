package com.manage.manager.dao;

import com.manage.student.entities.Payment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("managerPaymentDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_PaymentDAOImpl implements Manager_PaymentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_PaymentDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void savePayment(Payment payment) {
        sessionFactory.getCurrentSession().saveOrUpdate(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        sessionFactory.getCurrentSession().update(payment);
    }

    @Override
    public void deletePayment(Long paymentId) {
        Payment payment = sessionFactory.getCurrentSession().byId(Payment.class).load(paymentId);
        sessionFactory.getCurrentSession().delete(payment);
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
