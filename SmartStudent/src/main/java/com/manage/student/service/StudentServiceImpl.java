package com.manage.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.dao.StudentDAO;
import com.manage.student.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {
    
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}


	@Override
    @Transactional(transactionManager = "studentTransactionManager")
    public boolean validateStudent(String username, String password) {
        Student student = studentDAO.getStudentByUsername(username);
        return student != null && student.getPassword().equals(password);
    }
}
