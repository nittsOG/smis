package com.manage.student.dao;

import com.manage.home.entities.Subject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentSubjectDaoImpl")
@Transactional("studentTransactionManager")
public class Student_SubjectDaoImpl implements Student_SubjectDao {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_SubjectDaoImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public Subject findById(Long id) {
        return sessionFactory.getCurrentSession().get(Subject.class, id);
    }

    // Implement more read-only methods as needed
}
