package com.manage.admin.service;

import com.manage.student.entities.Payment;
import java.util.List;

public interface Admin_PaymentService {
    Payment getPaymentById(Long paymentId);
    void savePayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(Long paymentId);
    List<Payment> getAllPayments();
}
