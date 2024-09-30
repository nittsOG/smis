package com.manage.manager.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.entities.FacultyAddress;

@Repository
@Qualifier("managerFacultyAddressDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_FacultyAddressDAOImpl implements Manager_FacultyAddressDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_FacultyAddressDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public FacultyAddress getFacultyAddressById(Long facultyAddressId) {
        return sessionFactory.getCurrentSession().get(FacultyAddress.class, facultyAddressId);
    }

    @Override
    public void saveFacultyAddress(FacultyAddress facultyAddress) {
        sessionFactory.getCurrentSession().save(facultyAddress);
    }

    @Override
    public void updateFacultyAddress(FacultyAddress facultyAddress) {
        sessionFactory.getCurrentSession().update(facultyAddress);
    }

    @Override
    public void deleteFacultyAddress(FacultyAddress facultyAddress) {
        sessionFactory.getCurrentSession().delete(facultyAddress);
    }

    @Override
    public FacultyAddress getFacultyAddressByFacultytId(Long facultyId) {
        String hql = "FROM FacultyAddress sa WHERE sa.faculty.facultyId = :facultyId";
        Query<FacultyAddress> query = sessionFactory.getCurrentSession().createQuery(hql, FacultyAddress.class);
        query.setParameter("facultyId", facultyId);
        return query.uniqueResult();
    }

    @Override
    public void createFacultyAddress(FacultyAddress facultyAddress) {
        sessionFactory.getCurrentSession().save(facultyAddress);
    }

    @Override
    public void deleteFacultyAddressById(long facultyAddressId) {
        this.deleteFacultyAddress(this.getFacultyAddressById(facultyAddressId));
    }
}
