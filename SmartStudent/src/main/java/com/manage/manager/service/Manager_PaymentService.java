package com.manage.manager.service;

import com.manage.student.entities.Payment;
import java.util.List;

public interface Manager_PaymentService {
    void savePayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(Long paymentId);
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPayments();
}
