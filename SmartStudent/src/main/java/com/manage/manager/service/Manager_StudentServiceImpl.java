package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.Student;
import com.manage.manager.dao.Manager_StudentDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_StudentServiceImpl implements Manager_StudentService {

    private final Manager_StudentDAO managerStudentDAO;

    @Autowired
    public Manager_StudentServiceImpl(Manager_StudentDAO managerStudentDAO) {
        this.managerStudentDAO = managerStudentDAO;
    }

    @Override
    public Student getStudentById(Long studentId) {
        return managerStudentDAO.getStudentById(studentId);
    }

    @Override
    public void saveStudent(Student student) {
        managerStudentDAO.saveStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        managerStudentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        managerStudentDAO.deleteStudent(student);
    }
}
