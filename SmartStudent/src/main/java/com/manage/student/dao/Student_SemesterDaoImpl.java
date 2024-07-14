package com.manage.student.dao;

import com.manage.home.entities.Semester;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("studentSemesterDaoImpl")
@Transactional("studentTransactionManager")
public class Student_SemesterDaoImpl implements Student_SemesterDao {

    private SessionFactory sessionFactory;

    @Autowired
    public Student_SemesterDaoImpl(@Qualifier("studentSessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public Semester findById(Long id) {
        return sessionFactory.getCurrentSession().get(Semester.class, id);
    }

    // Implement more read-only methods as needed
}
