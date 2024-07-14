package com.manage.faculty.service;

import com.manage.home.entities.Department;

public interface FacultyDepartmentService {
    Department getDepartmentById(Long departmentId);
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
}
