package com.manage.manager.service;

import java.util.List;

import com.manage.home.entities.Department;

public interface Manager_DepartmentService {
    Department getDepartmentById(Long departmentId);
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
	List<Department> getAllDepartments();
	void deleteDepartment(Long departmentId);
}
