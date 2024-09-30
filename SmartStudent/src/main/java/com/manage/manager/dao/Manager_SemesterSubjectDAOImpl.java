package com.manage.manager.dao;

import com.manage.home.entities.SemesterSubject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("managerSemesterSubjectDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_SemesterSubjectDAOImpl implements Manager_SemesterSubjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_SemesterSubjectDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
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

	@Override
	public void deleteSemesterSubject(SemesterSubject semesterSubject) {
		this.deleteSemesterSubject(semesterSubject.getSemesterSubjectId());
	}
}
