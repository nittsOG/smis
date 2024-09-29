package com.manage.admin.dao;

import com.manage.home.entities.SemesterSubject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("adminSemesterSubjectDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_SemesterSubjectDAOImpl implements Admin_SemesterSubjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Admin_SemesterSubjectDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveSemesterSubject(SemesterSubject semesterSubject) {
        sessionFactory.getCurrentSession().saveOrUpdate(semesterSubject);
    }

    @Override
    public void updateSemesterSubject(SemesterSubject semesterSubject) {
        sessionFactory.getCurrentSession().update(semesterSubject);
    }

    @Override
    public void deleteSemesterSubject(Long semesterSubjectId) {
        SemesterSubject semesterSubject = sessionFactory.getCurrentSession().byId(SemesterSubject.class).load(semesterSubjectId);
        sessionFactory.getCurrentSession().delete(semesterSubject);
    }

    @Override
    public SemesterSubject getSemesterSubjectById(Long semesterSubjectId) {
        return sessionFactory.getCurrentSession().get(SemesterSubject.class, semesterSubjectId);
    }

    @Override
    public List<SemesterSubject> getAllSemesterSubjects() {
        return sessionFactory.getCurrentSession().createQuery("from SemesterSubject", SemesterSubject.class).list();
    }
    
    @Override
    public List<SemesterSubject> getSemesterSubjectsBySubjectId(Long subjectId) {
        return sessionFactory.getCurrentSession()
            .createQuery("from SemesterSubject where subject.subjectId = :subjectId", SemesterSubject.class)
            .setParameter("subjectId", subjectId)
            .list();
    }

}
