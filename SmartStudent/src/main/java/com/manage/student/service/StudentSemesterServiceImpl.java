package com.manage.student.service;

import com.manage.home.entities.Semester;
import com.manage.student.dao.Student_SemesterDao;
import com.manage.student.entities.StudentSemester;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("studentSemesterServiceImpl")
public class StudentSemesterServiceImpl implements StudentSemesterService {

    private final Student_SemesterDao semesterDao;

    @Autowired
    public StudentSemesterServiceImpl(@Qualifier("studentSemesterDaoImpl") Student_SemesterDao semesterDao) {
        this.semesterDao = semesterDao;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public Semester findById(Long id) {
        return semesterDao.findById(id);
    }

    @Override
    public List<StudentSemester> getSemestersByStudentId(Long studentId) {
        return semesterDao.findSemestersByStudentId(studentId);
    }

    // Implement more service methods if needed
}
