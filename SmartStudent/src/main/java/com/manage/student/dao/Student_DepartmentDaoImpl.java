package com.manage.student.dao;

import com.manage.home.entities.Department;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentDepartmentDaoImpl")
@Transactional("studentTransactionManager")
public class Student_DepartmentDaoImpl implements Student_DepartmentDao {

    private SessionFactory sessionFactory;
    
    @Autowired
	public Student_DepartmentDaoImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    @Override
    public Department findById(Long id) {
        return sessionFactory.getCurrentSession().get(Department.class, id);
    }


    // Implement more read-only methods as needed
}
