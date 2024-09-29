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
public class Admin_FeeServiceImpl implements Admin_FeeService {

    private final Admin_FeeDAO adminFeeDAO;

    @Autowired
    public Admin_FeeServiceImpl(@Qualifier("adminFeeDAOImpl") Admin_FeeDAO adminFeeDAO) {
        this.adminFeeDAO = adminFeeDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Fee getFeeById(Long feeId) {
        Fee fee = adminFeeDAO.getFeeById(feeId);
//        initializeFee(fee);
        return fee;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveFee(Fee fee) {
        adminFeeDAO.saveFee(fee);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateFee(Fee fee) {
        adminFeeDAO.updateFee(fee);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteFee(Long feeId) {
        Fee fee = getFeeById(feeId);
        if (fee != null) {
            adminFeeDAO.deleteFee(feeId);;
        }
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Fee> getAllFees() {
        List<Fee> fees = adminFeeDAO.getAllFees();
//        fees.forEach(this::initializeFee);
        return fees;
    }

//    private void initializeFee(Fee fee) {
//        if (fee != null && fee.getStudent() != null) {
//            fee.getStudent().getUsername();
//        }
//    }
    
    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Fee> getFeesByStudentId(Long studentId) {
        return adminFeeDAO.getFeesByStudentId(studentId);
    }
    
    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Long saveFeeAndReturnId(Fee fee) {
        adminFeeDAO.saveFee(fee);
        return fee.getFeeId();
    }

}
