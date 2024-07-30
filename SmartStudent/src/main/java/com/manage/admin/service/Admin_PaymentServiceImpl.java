package com.manage.admin.service;

import com.manage.admin.dao.Admin_PaymentDAO;
import com.manage.student.entities.Payment;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminPaymentServiceImpl")
@Transactional(transactionManager = "adminTransactionManager")
public class Admin_PaymentServiceImpl implements Admin_PaymentService {

    private final Admin_PaymentDAO paymentDao;

    @Autowired
    public Admin_PaymentServiceImpl(@Qualifier("adminPaymentDAOImpl") Admin_PaymentDAO paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        Payment payment = paymentDao.getPaymentById(paymentId);
        // Initialize lazy property
        if (payment != null && payment.getFee() != null) {
            Hibernate.initialize(payment.getFee()); // Ensure fee is initialized
        }
        return payment;
    }

    @Override
    public void savePayment(Payment payment) {
        paymentDao.savePayment(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentDao.updatePayment(payment);
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentDao.deletePayment(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        List<Payment> payments = paymentDao.getAllPayments();
        for (Payment payment : payments) {
            // Initialize lazy property
            if (payment.getFee() != null) {
                Hibernate.initialize(payment.getFee()); // Ensure fee is initialized
            }
        }
        return payments;
    }
}
