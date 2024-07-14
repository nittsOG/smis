package com.manage.student.dao;

import com.manage.home.entities.Division;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("studentDivisionDAOImpl")
@Transactional("studentTransactionManager")
public class Student_DivisionDAOImpl implements Student_DivisionDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_DivisionDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Division findById(Long id) {
        return sessionFactory.getCurrentSession().get(Division.class, id);
    }

    @Override
    public List<Division> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Division", Division.class).list();
    }
}
