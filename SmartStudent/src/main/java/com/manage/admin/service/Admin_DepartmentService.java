package com.manage.admin.service;

import com.manage.home.entities.Department;

import java.util.List;

public interface Admin_DepartmentService {
    void saveDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(Long departmentId);

    Department getDepartmentById(Long departmentId);

    List<Department> getAllDepartments();
}
