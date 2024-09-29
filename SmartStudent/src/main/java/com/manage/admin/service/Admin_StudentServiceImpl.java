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
        Student student = adminStudentDAO.getStudentById(studentId);
        initializeStudent(student);
        return student;
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
        List<Student> students = adminStudentDAO.getAllStudents();
        students.forEach(this::initializeStudent);
        return students;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Student> getStudentsByDivision(String divisionName) {
        List<Student> students = adminStudentDAO.getStudentsByDivision(divisionName);
        students.forEach(this::initializeStudent);
        return students;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Student> getStudentsByDepartment(String departmentName) {
        List<Student> students = adminStudentDAO.getStudentsByDepartment(departmentName);
        students.forEach(this::initializeStudent);
        return students;
    }

    private void initializeStudent(Student student) {
        if (student != null && student.getDivision() != null) {
            student.getDivision().getName();
            if (student.getDivision().getDepartment() != null) {
                student.getDivision().getDepartment().getName();
            }
        }
    }
    
    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void createStudent(Student student) {
        adminStudentDAO.createStudent(student);
    }
    
    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteStudentById(Long studentId) {
        // First, fetch the student to make sure it exists
        Student student = adminStudentDAO.getStudentById(studentId);
        
        if (student != null) {
            // Delete the student
            adminStudentDAO.deleteStudent(student);
        }
    }


}
