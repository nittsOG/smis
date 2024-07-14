package com.manage.admin.service;

import com.manage.admin.dao.Admin_FeeDAO;
import com.manage.student.entities.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminFeeServiceImpl")
@Transactional(transactionManager = "adminTransactionManager")
public class Admin_FeeServiceImpl implements Admin_FeeService {

    private final Admin_FeeDAO feeDao;

    @Autowired
    public Admin_FeeServiceImpl(@Qualifier("adminFeeDAOImpl") Admin_FeeDAO feeDao) {
        this.feeDao = feeDao;
    }

    @Override
    public Fee getFeeById(Long feeId) {
        return feeDao.getFeeById(feeId);
    }

    @Override
    public void saveFee(Fee fee) {
        feeDao.saveFee(fee);
    }

    @Override
    public void updateFee(Fee fee) {
        feeDao.updateFee(fee);
    }

    @Override
    public void deleteFee(Long feeId) {
        feeDao.deleteFee(feeId);
    }

    @Override
    public List<Fee> getAllFees() {
        return feeDao.getAllFees();
    }
}
