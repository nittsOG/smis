package com.manage.faculty.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.manage.home.entities.Division;

@Repository
@Qualifier("facultyDivisionDAOImpl")
@Transactional("facultyTransactionManager")
public class Faculty_DivisionDAOImpl implements Faculty_DivisionDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Faculty_DivisionDAOImpl(@Qualifier("facultySessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Division> getDivisionsByFacultyId(Long facultyId) {
        String hql = "SELECT fd.division FROM FacultyDivision fd WHERE fd.faculty.facultyId = :facultyId";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, Division.class)
                .setParameter("facultyId", facultyId)
                .getResultList();
    }


    @Override
    public Division getDivisionById(Long divisionId) {
        return sessionFactory.getCurrentSession().get(Division.class, divisionId);
    }

    @Override
    public void saveDivision(Division division) {
        sessionFactory.getCurrentSession().save(division);
    }

    @Override
    public void updateDivision(Division division) {
        sessionFactory.getCurrentSession().update(division);
    }

    @Override
    public void deleteDivision(Division division) {
        sessionFactory.getCurrentSession().delete(division);
    }
}

