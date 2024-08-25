package com.manage.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.student.dao.StudentDAO;
import com.manage.student.entities.Student;

@Service
@Qualifier("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    
    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public boolean validateStudent(Long id, String password) {
        Student student = studentDAO.getStudentById(id);
        return student != null && student.getPassword().equals(password);
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public Student getStudentById(Long id) {
//        return studentDAO.getStudentById(id);
        Student student = studentDAO.getStudentById(id);
        initializeStudent(student);
        return student;
        
    }

    private void initializeStudent(Student student) {
        if (student != null && student.getDivision() != null) {
            student.getDivision().getName();
            if (student.getDivision().getDepartment() != null) {
                student.getDivision().getDepartment().getName();
            }
        }
    }

//    @Override
//    @Transactional(transactionManager = "studentTransactionManager")
//    public Student getStudentByEmail(String email) {
//        return studentDAO.getStudentByEmail(email);
//    }
}
