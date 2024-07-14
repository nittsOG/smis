package com.manage.admin.service;

import com.manage.admin.dao.Admin_PaymentDAO;
import com.manage.student.entities.Payment;
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
        return paymentDao.getPaymentById(paymentId);
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
        return paymentDao.getAllPayments();
    }
}
