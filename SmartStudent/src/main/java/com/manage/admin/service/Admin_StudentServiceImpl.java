package com.manage.admin.service;

import com.manage.admin.dao.Admin_StudentDAO;
import com.manage.student.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminStudentServiceImpl")
public class Admin_StudentServiceImpl implements Admin_StudentService {

    private final Admin_StudentDAO adminStudentDAO;

    @Autowired
    public Admin_StudentServiceImpl(@Qualifier("adminStudentDAOImpl") Admin_StudentDAO adminStudentDAO) {
        this.adminStudentDAO = adminStudentDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public Student getStudentById(Long studentId) {
        return adminStudentDAO.getStudentById(studentId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveStudent(Student student) {
        adminStudentDAO.saveStudent(student);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateStudent(Student student) {
        adminStudentDAO.updateStudent(student);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteStudent(Long studentId) {
        Student student = getStudentById(studentId);
        adminStudentDAO.deleteStudent(student);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Student> getAllStudents() {
        return adminStudentDAO.getAllStudents();
    }
}
