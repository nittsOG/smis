package com.manage.manager.service;

import com.manage.student.entities.Payment;
import com.manage.manager.dao.Manager_PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("managerTransactionManager")
public class Manager_PaymentServiceImpl implements Manager_PaymentService {

    private final Manager_PaymentDAO managerPaymentDAO;

    @Autowired
    public Manager_PaymentServiceImpl(Manager_PaymentDAO managerPaymentDAO) {
        this.managerPaymentDAO = managerPaymentDAO;
    }

    @Override
    public void savePayment(Payment payment) {
        managerPaymentDAO.savePayment(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        managerPaymentDAO.updatePayment(payment);
    }

    @Override
    public void deletePayment(Long paymentId) {
        managerPaymentDAO.deletePayment(paymentId);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return managerPaymentDAO.getPaymentById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return managerPaymentDAO.getAllPayments();
    }
}
