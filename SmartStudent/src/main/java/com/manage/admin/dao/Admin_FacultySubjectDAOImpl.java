package com.manage.admin.dao;

import com.manage.faculty.entities.FacultySubject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("adminFacultySubjectDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_FacultySubjectDAOImpl implements Admin_FacultySubjectDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public Admin_FacultySubjectDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveFacultySubject(FacultySubject facultySubject) {
	    // Check if the Faculty is transient (unsaved), and if so, save it first.
	    if (facultySubject.getFaculty() != null && facultySubject.getFaculty().getFacultyId() == null) {
	        sessionFactory.getCurrentSession().save(facultySubject.getFaculty());
	    }
	    
	    // Save the FacultySubject after ensuring Faculty is saved
	    sessionFactory.getCurrentSession().saveOrUpdate(facultySubject);
	}


	@Override
	public void updateFacultySubject(FacultySubject facultySubject) {
		sessionFactory.getCurrentSession().update(facultySubject);
	}

	@Override
	public void deleteFacultySubject(Long facultySubjectId) {
		FacultySubject facultySubject = sessionFactory.getCurrentSession().byId(FacultySubject.class)
				.load(facultySubjectId);
		sessionFactory.getCurrentSession().delete(facultySubject);
	}

	@Override
	public FacultySubject getFacultySubjectById(Long facultySubjectId) {
		return sessionFactory.getCurrentSession().get(FacultySubject.class, facultySubjectId);
	}

	@Override
	public List<FacultySubject> getAllFacultySubjects() {
		return sessionFactory.getCurrentSession().createQuery("from FacultySubject", FacultySubject.class).list();
	}

	@Override
	public List<FacultySubject> getFacultySubjectsByFacultyId(Long facultyId) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM FacultySubject WHERE faculty.facultyId = :facultyId", FacultySubject.class)
				.setParameter("facultyId", facultyId).getResultList();
	}
}
