package com.manage.admin.dao;

import com.manage.student.entities.Fee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("adminFeeDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_FeeDAOImpl implements Admin_FeeDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Admin_FeeDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveFee(Fee fee) {
        sessionFactory.getCurrentSession().saveOrUpdate(fee);
    }

    @Override
    public void updateFee(Fee fee) {
        sessionFactory.getCurrentSession().update(fee);
    }

    @Override
    public void deleteFee(Long feeId) {
        Fee fee = sessionFactory.getCurrentSession().byId(Fee.class).load(feeId);
        sessionFactory.getCurrentSession().delete(fee);
    }

    @Override
    public Fee getFeeById(Long feeId) {
        return sessionFactory.getCurrentSession().get(Fee.class, feeId);
    }

    @Override
    public List<Fee> getAllFees() {
        return sessionFactory.getCurrentSession().createQuery("from Fee", Fee.class).list();
    }

    @Override
    public List<Fee> getFeesByStudentId(Long studentId) {
        String hql = "select f from Fee f " +
                     "join f.studentSemester ss " +
                     "join ss.student s " +
                     "where s.studentId = :studentId";
        return sessionFactory.getCurrentSession()
                .createQuery(hql, Fee.class)
                .setParameter("studentId", studentId)
                .getResultList();
    }

}
