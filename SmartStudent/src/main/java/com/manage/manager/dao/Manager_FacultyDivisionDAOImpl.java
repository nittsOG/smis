package com.manage.manager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.entities.FacultyDivision;

import java.util.List;

@Repository
@Qualifier("managerFacultyDivisionDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_FacultyDivisionDAOImpl implements Manager_FacultyDivisionDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Manager_FacultyDivisionDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
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
