package com.manage.admin.service;

import com.manage.student.entities.Fee;
import java.util.List;

public interface Admin_FeeService {
    Fee getFeeById(Long feeId);
    void saveFee(Fee fee);
    void updateFee(Fee fee);
    void deleteFee(Long feeId);
    List<Fee> getAllFees();
}
