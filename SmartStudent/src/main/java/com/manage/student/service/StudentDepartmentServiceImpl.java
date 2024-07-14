package com.manage.student.service;

import com.manage.home.entities.Department;
import com.manage.student.dao.Student_DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("studentDepartmentServiceImpl")
public class StudentDepartmentServiceImpl implements StudentDepartmentService {

    private final Student_DepartmentDao departmentDao;

    @Autowired
    public StudentDepartmentServiceImpl(@Qualifier("studentDepartmentDaoImpl") Student_DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public Department findById(Long id) {
        return departmentDao.findById(id);
    }

    // Implement more service methods if needed
}
