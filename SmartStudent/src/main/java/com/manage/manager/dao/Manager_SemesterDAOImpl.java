package com.manage.manager.dao;

import com.manage.home.entities.Semester;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("managerSemesterDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_SemesterDAOImpl implements Manager_SemesterDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_SemesterDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveSemester(Semester semester) {
        sessionFactory.getCurrentSession().saveOrUpdate(semester);
    }

    @Override
    public void updateSemester(Semester semester) {
        sessionFactory.getCurrentSession().update(semester);
    }

    @Override
    public void deleteSemester(Long semesterId) {
        Semester semester = sessionFactory.getCurrentSession().byId(Semester.class).load(semesterId);
        sessionFactory.getCurrentSession().delete(semester);
    }

    @Override
    public Semester getSemesterById(Long semesterId) {
        return sessionFactory.getCurrentSession().get(Semester.class, semesterId);
    }

    @Override
    public List<Semester> getAllSemesters() {
        return sessionFactory.getCurrentSession().createQuery("from Semester", Semester.class).list();
    }

    @Override
    public List<Semester> getSemestersByCourseId(Long courseId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Semester where course.courseId = :courseId", Semester.class)
                .setParameter("courseId", courseId)
                .list();
    }

	@Override
	public void deleteSemester(Semester semester) {
		this.deleteSemester(semester.getSemesterId());
	}
}
