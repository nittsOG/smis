package com.manage.manager.service;

import com.manage.manager.dao.Manager_StudentAddressDAO;
import com.manage.student.entities.StudentAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("managerStudentAddressServiceImpl")
public class Manager_StudentAddressServiceImpl implements Manager_StudentAddressService {

    private final Manager_StudentAddressDAO managerStudentAddressDAO;

    @Autowired
    public Manager_StudentAddressServiceImpl(@Qualifier("managerStudentAddressDAOImpl") Manager_StudentAddressDAO managerStudentAddressDAO) {
        this.managerStudentAddressDAO = managerStudentAddressDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public StudentAddress getStudentAddressById(Long studentAddressId) {
        return managerStudentAddressDAO.getStudentAddressById(studentAddressId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveStudentAddress(StudentAddress studentAddress) {
        managerStudentAddressDAO.saveStudentAddress(studentAddress);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateStudentAddress(StudentAddress studentAddress) {
        managerStudentAddressDAO.updateStudentAddress(studentAddress);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteStudentAddress(Long studentAddressId) {
        managerStudentAddressDAO.deleteStudentAddress(managerStudentAddressDAO.getStudentAddressById(studentAddressId));
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void createStudentAddress(StudentAddress studentAddress) {
        managerStudentAddressDAO.saveStudentAddress(studentAddress);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public StudentAddress getStudentAddressByStudentId(Long studentId) {
        return managerStudentAddressDAO.getStudentAddressByStudentId(studentId);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteStudentAddressByStudentId(Long studentId) {
        StudentAddress studentAddress = managerStudentAddressDAO.getStudentAddressByStudentId(studentId);
        if (studentAddress != null) {
            managerStudentAddressDAO.deleteStudentAddress(studentAddress);
        }
    }

	@Override
	public void deleteStudentAddress(StudentAddress studentAddress) {
		this.deleteStudentAddress(studentAddress.getStudentAddressId());
	}

}
