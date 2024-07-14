package com.manage.faculty.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Department;

@Repository
@Qualifier("facultyDepartmentDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_DepartmentDAOImpl implements Faculty_DepartmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Faculty_DepartmentDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return sessionFactory.getCurrentSession().get(Department.class, departmentId);
    }

    @Override
    public void saveDepartment(Department department) {
        sessionFactory.getCurrentSession().save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        sessionFactory.getCurrentSession().update(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        sessionFactory.getCurrentSession().delete(department);
    }
}
