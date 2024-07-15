package com.manage.student.dao;

import com.manage.faculty.entities.FacultySubject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("studentFacultySubjectDAOImpl")
@Transactional("studentTransactionManager")
public class Student_FacultySubjectDAOImpl implements Student_FacultySubjectDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public Student_FacultySubjectDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public FacultySubject getFacultySubjectById(Long facultySubjectId) {
        return sessionFactory.getCurrentSession().get(FacultySubject.class, facultySubjectId);
    }

    @Override
    public List<FacultySubject> getAllFacultySubjects() {
        return sessionFactory.getCurrentSession().createQuery("from FacultySubject", FacultySubject.class).list();
    }
}
