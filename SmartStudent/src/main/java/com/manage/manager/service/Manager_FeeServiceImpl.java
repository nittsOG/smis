package com.manage.manager.service;

import com.manage.manager.dao.Manager_FeeDAO;
import com.manage.student.entities.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerFeeServiceImpl")
public class Manager_FeeServiceImpl implements Manager_FeeService {

    private final Manager_FeeDAO managerFeeDAO;

    @Autowired
    public Manager_FeeServiceImpl(@Qualifier("managerFeeDAOImpl") Manager_FeeDAO managerFeeDAO) {
        this.managerFeeDAO = managerFeeDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Fee getFeeById(Long feeId) {
        return managerFeeDAO.getFeeById(feeId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveFee(Fee fee) {
        managerFeeDAO.saveFee(fee);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateFee(Fee fee) {
        managerFeeDAO.updateFee(fee);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteFee(Long feeId) {
        Fee fee = getFeeById(feeId);
        if (fee != null) {
            managerFeeDAO.deleteFee(feeId);
        }
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Fee> getAllFees() {
        return managerFeeDAO.getAllFees();
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Fee> getFeesByStudentId(Long studentId) {
        return managerFeeDAO.getFeesByStudentId(studentId);
    }
    
    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Long saveFeeAndReturnId(Fee fee) {
        managerFeeDAO.saveFee(fee);
        return fee.getFeeId();
    }
}
