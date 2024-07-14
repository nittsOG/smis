package com.manage.admin.dao;

import com.manage.student.entities.Payment;
import java.util.List;

public interface Admin_PaymentDAO {
    void savePayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(Long paymentId);
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPayments();
}
