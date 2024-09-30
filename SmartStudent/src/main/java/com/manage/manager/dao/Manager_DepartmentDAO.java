package com.manage.manager.dao;

import java.util.List;

import com.manage.home.entities.Department;

public interface Manager_DepartmentDAO {
    Department getDepartmentById(Long departmentId);
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
	void deleteDepartment(Long departmentId);
	List<Department> getAllDepartments();
}
