package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Department;
import com.manage.manager.dao.Manager_DepartmentDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_DepartmentServiceImpl implements Manager_DepartmentService {

    private final Manager_DepartmentDAO managerDepartmentDAO;

    @Autowired
    public Manager_DepartmentServiceImpl(Manager_DepartmentDAO managerDepartmentDAO) {
        this.managerDepartmentDAO = managerDepartmentDAO;
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return managerDepartmentDAO.getDepartmentById(departmentId);
    }

    @Override
    public void saveDepartment(Department department) {
        managerDepartmentDAO.saveDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        managerDepartmentDAO.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        managerDepartmentDAO.deleteDepartment(department);
    }
}
