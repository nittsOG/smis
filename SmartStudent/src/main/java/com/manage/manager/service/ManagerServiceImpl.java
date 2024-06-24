package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.manager.dao.ManagerDAO;
import com.manage.manager.entities.Manager;

@Service
public class ManagerServiceImpl implements ManagerService {
    
    private ManagerDAO managerDAO;

    @Autowired
    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public boolean validateManager(String username, String password) {
        Manager manager = managerDAO.getManagerByUsername(username);
        return manager != null && manager.getPassword().equals(password);
    }
}
