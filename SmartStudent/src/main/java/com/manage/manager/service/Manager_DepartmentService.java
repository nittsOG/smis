package com.manage.manager.service;

import com.manage.home.entities.Department;

public interface Manager_DepartmentService {
    Department getDepartmentById(Long departmentId);
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
}
