package com.manage.manager.service;

import com.manage.student.entities.Fee;
import com.manage.manager.dao.Manager_FeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("managerTransactionManager")
public class Manager_FeeServiceImpl implements Manager_FeeService {

    private final Manager_FeeDAO managerFeeDAO;

    @Autowired
    public Manager_FeeServiceImpl(Manager_FeeDAO managerFeeDAO) {
        this.managerFeeDAO = managerFeeDAO;
    }

    @Override
    public void saveFee(Fee fee) {
        managerFeeDAO.saveFee(fee);
    }

    @Override
    public void updateFee(Fee fee) {
        managerFeeDAO.updateFee(fee);
    }

    @Override
    public void deleteFee(Long feeId) {
        managerFeeDAO.deleteFee(feeId);
    }

    @Override
    public Fee getFeeById(Long feeId) {
        return managerFeeDAO.getFeeById(feeId);
    }

    @Override
    public List<Fee> getAllFees() {
        return managerFeeDAO.getAllFees();
    }
}
