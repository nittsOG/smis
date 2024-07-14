package com.manage.admin.service;

import com.manage.admin.dao.Admin_ManagerDAO;
import com.manage.manager.entities.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("adminManagerServiceImpl")
public class Admin_ManagerServiceImpl implements Admin_ManagerService {

    private final Admin_ManagerDAO adminManagerDAO;

    @Autowired
    public Admin_ManagerServiceImpl(@Qualifier("adminManagerDAOImpl") Admin_ManagerDAO adminManagerDAO) {
        this.adminManagerDAO = adminManagerDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Manager getManagerById(Long managerId) {
        return adminManagerDAO.getManagerById(managerId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveManager(Manager manager) {
        adminManagerDAO.saveManager(manager);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateManager(Manager manager) {
        adminManagerDAO.updateManager(manager);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteManager(Manager manager) {
        adminManagerDAO.deleteManager(manager);
    }
}
