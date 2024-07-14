package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.manager.dao.ManagerDAO;
import com.manage.manager.entities.Manager;

@Service
public class ManagerServiceImpl implements ManagerService {
    
    private final ManagerDAO managerDAO;

    @Autowired
    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public boolean validateManager(Long id, String password) {
        Manager manager = managerDAO.getManagerById(id);
        return manager != null && manager.getPassword().equals(password);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Manager getManagerByUsername(String username) {
        return managerDAO.getManagerByUsername(username);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Manager getManagerById(Long id) {
        return managerDAO.getManagerById(id);
    }

//    @Override
//    @Transactional(transactionManager = "managerTransactionManager")
//    public Manager getManagerByEmail(String email) {
//        return managerDAO.getManagerByEmail(email);
//    }
}
