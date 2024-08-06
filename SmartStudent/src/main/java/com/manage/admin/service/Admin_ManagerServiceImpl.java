package com.manage.admin.service;

import com.manage.admin.dao.Admin_ManagerDAO;
import com.manage.manager.entities.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Manager manager = adminManagerDAO.getManagerById(managerId);
        if (manager != null) {
            // Access to initialize lazy properties
            if (manager.getDepartment() != null) {
                manager.getDepartment().getName();
            }
            if (manager.getAddress() != null) {
                manager.getAddress(); // Forces initialization
            }
        }
        return manager;
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
        if (manager != null) {
            // Access department to avoid LazyInitializationException
            if (manager.getDepartment() != null) {
                manager.getDepartment().getName();
            }
            adminManagerDAO.deleteManager(manager);
        }
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Manager> getAllManagers() {
        List<Manager> managers = adminManagerDAO.getAllManagers();
        for (Manager manager : managers) {
            // Initialize lazy properties
            if (manager.getDepartment() != null) {
                manager.getDepartment().getName(); // Initialize department
            }
            manager.getAddress(); // Initialize addresses collection
        }
        return managers;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteManager(Long managerId) {
        Manager manager = getManagerById(managerId);
        if (manager != null) {
            deleteManager(manager);
        }
    }
}
