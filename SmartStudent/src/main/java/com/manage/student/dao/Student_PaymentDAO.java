package com.manage.student.dao;

import com.manage.student.entities.Payment;
import java.util.List;

public interface Student_PaymentDAO {
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPayments();
}
