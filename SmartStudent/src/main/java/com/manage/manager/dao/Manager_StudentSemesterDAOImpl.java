package com.manage.manager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.StudentSemester;

@Repository
@Transactional("managerTransactionManager")
public class Manager_StudentSemesterDAOImpl implements Manager_StudentSemesterDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Manager_StudentSemesterDAOImpl(@Qualifier("managerSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public StudentSemester getStudentSemesterById(Long studentSemesterId) {
        return sessionFactory.getCurrentSession().get(StudentSemester.class, studentSemesterId);
    }

    @Override
    public void saveStudentSemester(StudentSemester studentSemester) {
        sessionFactory.getCurrentSession().save(studentSemester);
    }

    @Override
    public void updateStudentSemester(StudentSemester studentSemester) {
        sessionFactory.getCurrentSession().update(studentSemester);
    }

    @Override
    public void deleteStudentSemester(StudentSemester studentSemester) {
        sessionFactory.getCurrentSession().delete(studentSemester);
    }
}
