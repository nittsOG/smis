package com.manage.admin.service;

import com.manage.admin.dao.Admin_StudentAddressDAO;
import com.manage.student.entities.StudentAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("adminStudentAddressServiceImpl")
public class Admin_StudentAddressServiceImpl implements Admin_StudentAddressService {

    private final Admin_StudentAddressDAO adminStudentAddressDAO;

    @Autowired
    public Admin_StudentAddressServiceImpl(@Qualifier("adminStudentAddressDAOImpl") Admin_StudentAddressDAO adminStudentAddressDAO) {
        this.adminStudentAddressDAO = adminStudentAddressDAO;
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public StudentAddress getStudentAddressById(Long studentAddressId) {
        return adminStudentAddressDAO.getStudentAddressById(studentAddressId);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void saveStudentAddress(StudentAddress studentAddress) {
        adminStudentAddressDAO.saveStudentAddress(studentAddress);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void updateStudentAddress(StudentAddress studentAddress) {
        adminStudentAddressDAO.updateStudentAddress(studentAddress);
    }

    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public void deleteStudentAddress(Long studentAddressId) {
        StudentAddress studentAddress = getStudentAddressById(studentAddressId);
        adminStudentAddressDAO.deleteStudentAddress(studentAddress);
    }
}
