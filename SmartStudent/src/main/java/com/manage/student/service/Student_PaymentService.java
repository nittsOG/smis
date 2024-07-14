package com.manage.student.service;

import com.manage.student.entities.Payment;
import java.util.List;

public interface Student_PaymentService {
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPayments();
}
