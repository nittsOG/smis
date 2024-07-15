package com.manage.faculty.dao;

import com.manage.faculty.entities.FacultyDivision;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("facultyFacultyDivisionDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_FacultyDivisionDAOImpl implements Faculty_FacultyDivisionDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Faculty_FacultyDivisionDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public FacultyDivision getFacultyDivisionById(Long facultyDivisionId) {
        return sessionFactory.getCurrentSession().get(FacultyDivision.class, facultyDivisionId);
    }

    @Override
    public List<FacultyDivision> getAllFacultyDivisions() {
        return sessionFactory.getCurrentSession().createQuery("from FacultyDivision", FacultyDivision.class).list();
    }

    @Override
    public void updateFacultyDivision(FacultyDivision facultyDivision) {
        sessionFactory.getCurrentSession().update(facultyDivision);
    }
}
