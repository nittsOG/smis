package com.manage.manager.service;

import com.manage.manager.dao.Manager_DepartmentDAO;
import com.manage.home.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerDepartmentServiceImpl")
public class Manager_DepartmentServiceImpl implements Manager_DepartmentService {

    private final Manager_DepartmentDAO managerDepartmentDAO;

    @Autowired
    public Manager_DepartmentServiceImpl(@Qualifier("managerDepartmentDAOImpl") Manager_DepartmentDAO managerDepartmentDAO) {
        this.managerDepartmentDAO = managerDepartmentDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveDepartment(Department department) {
        managerDepartmentDAO.saveDepartment(department);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateDepartment(Department department) {
        managerDepartmentDAO.updateDepartment(department);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteDepartment(Long departmentId) {
        managerDepartmentDAO.deleteDepartment(departmentId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Department getDepartmentById(Long departmentId) {
        return managerDepartmentDAO.getDepartmentById(departmentId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Department> getAllDepartments() {
        return managerDepartmentDAO.getAllDepartments();
    }

	@Override
	public void deleteDepartment(Department department) {
		managerDepartmentDAO.deleteDepartment(department);
	}
}
