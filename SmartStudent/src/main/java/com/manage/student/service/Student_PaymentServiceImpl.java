package com.manage.student.service;

import com.manage.student.entities.Payment;
import com.manage.student.dao.Student_PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("studentTransactionManager")
public class Student_PaymentServiceImpl implements Student_PaymentService {

    private final Student_PaymentDAO studentPaymentDAO;

    @Autowired
    public Student_PaymentServiceImpl(Student_PaymentDAO studentPaymentDAO) {
        this.studentPaymentDAO = studentPaymentDAO;
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return studentPaymentDAO.getPaymentById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return studentPaymentDAO.getAllPayments();
    }
}
