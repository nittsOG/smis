package com.manage.admin.dao;

import com.manage.home.entities.Department;

import java.util.List;

public interface Admin_DepartmentDAO {
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Long departmentId);
    Department getDepartmentById(Long departmentId);
    List<Department> getAllDepartments();
}
