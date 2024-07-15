package com.manage.admin.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.entities.FacultyDivision;

import java.util.List;

@Repository
@Qualifier("adminFacultyDivisionDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_FacultyDivisionDAOImpl implements Admin_FacultyDivisionDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Admin_FacultyDivisionDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveFacultyDivision(FacultyDivision facultyDivision) {
        sessionFactory.getCurrentSession().saveOrUpdate(facultyDivision);
    }

    @Override
    public void updateFacultyDivision(FacultyDivision facultyDivision) {
        sessionFactory.getCurrentSession().update(facultyDivision);
    }

    @Override
    public void deleteFacultyDivision(Long facultyDivisionId) {
        FacultyDivision facultyDivision = sessionFactory.getCurrentSession().byId(FacultyDivision.class).load(facultyDivisionId);
        sessionFactory.getCurrentSession().delete(facultyDivision);
    }

    @Override
    public FacultyDivision getFacultyDivisionById(Long facultyDivisionId) {
        return sessionFactory.getCurrentSession().get(FacultyDivision.class, facultyDivisionId);
    }

    @Override
    public List<FacultyDivision> getAllFacultyDivisions() {
        return sessionFactory.getCurrentSession().createQuery("from FacultyDivision", FacultyDivision.class).list();
    }
}
