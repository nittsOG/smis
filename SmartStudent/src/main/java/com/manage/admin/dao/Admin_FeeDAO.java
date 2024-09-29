package com.manage.admin.dao;

import com.manage.student.entities.Fee;
import java.util.List;

public interface Admin_FeeDAO {
    void saveFee(Fee fee);
    void updateFee(Fee fee);
    void deleteFee(Long feeId);
    Fee getFeeById(Long feeId);
    List<Fee> getAllFees();
	List<Fee> getFeesByStudentId(Long studentId);
}
