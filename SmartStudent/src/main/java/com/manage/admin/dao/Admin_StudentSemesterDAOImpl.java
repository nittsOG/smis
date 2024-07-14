package com.manage.admin.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.StudentSemester;

@Repository
@Qualifier("adminStudentSemesterDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_StudentSemesterDAOImpl implements Admin_StudentSemesterDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public Admin_StudentSemesterDAOImpl(@Qualifier("adminSessionFactory") SessionFactory sessionFactory) {
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
