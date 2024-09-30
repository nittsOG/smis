package com.manage.manager.service;

import com.manage.student.entities.Fee;
import java.util.List;

public interface Manager_FeeService {
    void saveFee(Fee fee);
    void updateFee(Fee fee);
    void deleteFee(Long feeId);
    Fee getFeeById(Long feeId);
    List<Fee> getAllFees();
	List<Fee> getFeesByStudentId(Long studentId);
	Long saveFeeAndReturnId(Fee fee);
}
