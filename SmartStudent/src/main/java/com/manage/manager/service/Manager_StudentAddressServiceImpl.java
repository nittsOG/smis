package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.student.entities.StudentAddress;
import com.manage.manager.dao.Manager_StudentAddressDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_StudentAddressServiceImpl implements Manager_StudentAddressService {

    private final Manager_StudentAddressDAO managerStudentAddressDAO;

    @Autowired
    public Manager_StudentAddressServiceImpl(Manager_StudentAddressDAO managerStudentAddressDAO) {
        this.managerStudentAddressDAO = managerStudentAddressDAO;
    }

    @Override
    public StudentAddress getStudentAddressById(Long studentAddressId) {
        return managerStudentAddressDAO.getStudentAddressById(studentAddressId);
    }

    @Override
    public void saveStudentAddress(StudentAddress studentAddress) {
        managerStudentAddressDAO.saveStudentAddress(studentAddress);
    }

    @Override
    public void updateStudentAddress(StudentAddress studentAddress) {
        managerStudentAddressDAO.updateStudentAddress(studentAddress);
    }

    @Override
    public void deleteStudentAddress(StudentAddress studentAddress) {
        managerStudentAddressDAO.deleteStudentAddress(studentAddress);
    }
}
