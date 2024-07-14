package com.manage.student.dao;

import com.manage.student.entities.Fee;
import java.util.List;

public interface Student_FeeDAO {
    Fee getFeeById(Long feeId);
    List<Fee> getAllFees();
}
