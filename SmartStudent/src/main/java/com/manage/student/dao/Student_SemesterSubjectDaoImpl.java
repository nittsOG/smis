package com.manage.student.dao;

import com.manage.home.entities.SemesterSubject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentSemesterSubjectDaoImpl")
@Transactional("studentTransactionManager")
public class Student_SemesterSubjectDaoImpl implements Student_SemesterSubjectDao {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_SemesterSubjectDaoImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public SemesterSubject findById(Long id) {
        return sessionFactory.getCurrentSession().get(SemesterSubject.class, id);
    }

    // Implement more read-only methods as needed
}
