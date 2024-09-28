package com.manage.admin.dao;

import com.manage.student.entities.StudentSemester;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("adminStudentSemesterDAOImpl")
@Transactional("adminTransactionManager")
public class Admin_StudentSemesterDAOImpl implements Admin_StudentSemesterDAO {

    private final SessionFactory sessionFactory;

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

    @Override
    @SuppressWarnings("unchecked")
    public List<StudentSemester> getAllStudentSemesters() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM StudentSemester")
                .list();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<StudentSemester> getStudentSemestersByStudentId(Long studentId) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM StudentSemester ss WHERE ss.student.studentId = :studentId")
                .setParameter("studentId", studentId)
                .list();
    }

}
