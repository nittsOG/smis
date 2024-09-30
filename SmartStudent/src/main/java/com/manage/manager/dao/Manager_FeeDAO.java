package com.manage.manager.dao;

import com.manage.student.entities.Fee;
import java.util.List;

public interface Manager_FeeDAO {
    void saveFee(Fee fee);
    void updateFee(Fee fee);
    void deleteFee(Long feeId);
    Fee getFeeById(Long feeId);
    List<Fee> getAllFees();
	List<Fee> getFeesByStudentId(Long studentId);
}
