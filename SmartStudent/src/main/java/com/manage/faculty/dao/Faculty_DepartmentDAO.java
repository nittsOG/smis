package com.manage.faculty.dao;

import com.manage.home.entities.Department;

public interface Faculty_DepartmentDAO {
    Department getDepartmentById(Long departmentId);
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
}
