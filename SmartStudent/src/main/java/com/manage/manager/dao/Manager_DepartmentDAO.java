package com.manage.manager.dao;

import com.manage.home.entities.Department;

public interface Manager_DepartmentDAO {
    Department getDepartmentById(Long departmentId);
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
}
