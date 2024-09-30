package com.manage.manager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.entities.Faculty;

import java.util.List;

@Repository
@Qualifier("managerFacultyDAOImpl")
@Transactional("managerTransactionManager")
public class Manager_FacultyDAOImpl implements Manager_FacultyDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Manager_FacultyDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Faculty getFacultyById(Long facultyId) {
        return sessionFactory.getCurrentSession().get(Faculty.class, facultyId);
    }

    @Override
    public void saveFaculty(Faculty faculty) {
        sessionFactory.getCurrentSession().save(faculty);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        sessionFactory.getCurrentSession().update(faculty);
    }

    @Override
    public void deleteFaculty(Faculty faculty) {
        sessionFactory.getCurrentSession().delete(faculty);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Faculty> getAllFaculties() {
        return sessionFactory.getCurrentSession().createQuery("FROM Faculty").list();
    }
    
    @Override
    public List<Faculty> getFacultyByDepartment(String department) {
        return sessionFactory.getCurrentSession()
            .createQuery("FROM Faculty WHERE department.name = :departmentName", Faculty.class)
            .setParameter("departmentName", department)
            .getResultList();
    }

    @Override
    public void deleteFacultyById(Long facultyId) {
        Faculty faculty = getFacultyById(facultyId);
        if (faculty != null) {
            sessionFactory.getCurrentSession().delete(faculty);
        }
    }

    @Override
    public void createFaculty(Faculty faculty) {
        sessionFactory.getCurrentSession().save(faculty);
    }
}
