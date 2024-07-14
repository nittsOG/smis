package com.manage.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.faculty.dao.Faculty_DepartmentDAO;
import com.manage.home.entities.Department;

@Service
@Transactional("facultyTransactionManager")
public class FacultyDepartmentServiceImpl implements FacultyDepartmentService {

    private final Faculty_DepartmentDAO facultyDepartmentDAO;

    @Autowired
    public FacultyDepartmentServiceImpl(@Qualifier("facultyDepartmentDAOImpl") Faculty_DepartmentDAO facultyDepartmentDAO) {
        this.facultyDepartmentDAO = facultyDepartmentDAO;
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return facultyDepartmentDAO.getDepartmentById(departmentId);
    }

    @Override
    public void saveDepartment(Department department) {
        facultyDepartmentDAO.saveDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        facultyDepartmentDAO.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        facultyDepartmentDAO.deleteDepartment(department);
    }
}
