package com.manage.manager.dao;

import com.manage.home.entities.Subject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("managerSubjectDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_SubjectDAOImpl implements Manager_SubjectDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Manager_SubjectDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveSubject(Subject subject) {
        sessionFactory.getCurrentSession().saveOrUpdate(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        sessionFactory.getCurrentSession().update(subject);
    }

    @Override
    public void deleteSubject(Long subjectId) {
        Subject subject = sessionFactory.getCurrentSession().byId(Subject.class).load(subjectId);
        sessionFactory.getCurrentSession().delete(subject);
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        return sessionFactory.getCurrentSession().get(Subject.class, subjectId);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return sessionFactory.getCurrentSession().createQuery("from Subject", Subject.class).list();
    }

    @Override
    public List<Subject> getSubjectsByCourse(Long courseId) {
        String hql = "FROM Subject s WHERE s.course.courseId = :courseId";
        return sessionFactory.getCurrentSession()
                             .createQuery(hql, Subject.class)
                             .setParameter("courseId", courseId)
                             .list();
    }

	@Override
	public void deleteSubject(Subject subject) {
		this.deleteSubject(subject.getSubjectId());
	}
}
