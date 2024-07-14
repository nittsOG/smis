package com.manage.student.service;

import com.manage.student.entities.StudentAddress;
import com.manage.student.dao.StudentAddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("studentAddressServiceImpl")
public class StudentAddressServiceImpl implements StudentAddressService {

    private final StudentAddressDAO addressDao;

    @Autowired
    public StudentAddressServiceImpl(@Qualifier("studentAddressDAOImpl") StudentAddressDAO addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public StudentAddress getStudentAddressById(Long id) {
        return addressDao.getStudentAddressById(id);
    }

    // Implement more service methods if needed
}
