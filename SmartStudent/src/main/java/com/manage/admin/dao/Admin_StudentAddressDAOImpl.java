package com.manage.admin.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.StudentAddress;

@Repository
@Qualifier("adminStudentAddressDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_StudentAddressDAOImpl implements Admin_StudentAddressDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Admin_StudentAddressDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public StudentAddress getStudentAddressById(Long studentAddressId) {
        return sessionFactory.getCurrentSession().get(StudentAddress.class, studentAddressId);
    }

    @Override
    public void saveStudentAddress(StudentAddress studentAddress) {
        sessionFactory.getCurrentSession().save(studentAddress);
    }

    @Override
    public void updateStudentAddress(StudentAddress studentAddress) {
        sessionFactory.getCurrentSession().update(studentAddress);
    }

    @Override
    public void deleteStudentAddress(StudentAddress studentAddress) {
        sessionFactory.getCurrentSession().delete(studentAddress);
    }

    @Override
    public StudentAddress getStudentAddressByStudentId(Long studentId) {
        String hql = "FROM StudentAddress sa WHERE sa.student.studentId = :studentId";
        Query<StudentAddress> query = sessionFactory.getCurrentSession().createQuery(hql, StudentAddress.class);
        query.setParameter("studentId", studentId);
        
        System.out.println("/n/n"+query.uniqueResult().getCity());      
        return query.uniqueResult();
    }


	
	@Override
	public void createStudentAddress(StudentAddress studentAddress) {
	    sessionFactory.getCurrentSession().save(studentAddress);
	}

	@Override
	public void deleteStudentAddressById(long studentAddressId) {
		this.deleteStudentAddress(this.getStudentAddressById(studentAddressId));
		
	}

    
}
