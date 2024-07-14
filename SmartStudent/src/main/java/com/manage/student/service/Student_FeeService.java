package com.manage.student.service;

import com.manage.student.entities.Fee;
import java.util.List;

public interface Student_FeeService {
    Fee getFeeById(Long feeId);
    List<Fee> getAllFees();
}
