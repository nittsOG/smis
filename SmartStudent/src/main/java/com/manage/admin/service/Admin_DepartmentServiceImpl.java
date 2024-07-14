package com.manage.admin.service;

import com.manage.admin.dao.Admin_DepartmentDAO;
import com.manage.home.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminDepartmentServiceImpl")
public class Admin_DepartmentServiceImpl implements Admin_DepartmentService {

    private final Admin_DepartmentDAO adminDepartmentDAO;

    @Autowired
    public Admin_DepartmentServiceImpl(@Qualifier("adminDepartmentDAOImpl") Admin_DepartmentDAO adminDepartmentDAO) {
        this.adminDepartmentDAO = adminDepartmentDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveDepartment(Department department) {
        adminDepartmentDAO.saveDepartment(department);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateDepartment(Department department) {
        adminDepartmentDAO.updateDepartment(department);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteDepartment(Long departmentId) {
        adminDepartmentDAO.deleteDepartment(departmentId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Department getDepartmentById(Long departmentId) {
        return adminDepartmentDAO.getDepartmentById(departmentId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Department> getAllDepartments() {
        return adminDepartmentDAO.getAllDepartments();
    }
}
