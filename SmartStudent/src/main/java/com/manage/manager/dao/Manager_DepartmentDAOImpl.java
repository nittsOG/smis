package com.manage.manager.dao;

import com.manage.home.entities.Department;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("managerDepartmentDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_DepartmentDAOImpl implements Manager_DepartmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_DepartmentDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveDepartment(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }

    @Override
    public void updateDepartment(Department department) {
        sessionFactory.getCurrentSession().update(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = sessionFactory.getCurrentSession().byId(Department.class).load(departmentId);
        sessionFactory.getCurrentSession().delete(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return sessionFactory.getCurrentSession().get(Department.class, departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return sessionFactory.getCurrentSession().createQuery("from Department", Department.class).list();
    }

	@Override
	public void deleteDepartment(Department department) {
		this.deleteDepartment(department.getDepartmentId());
	}
}
