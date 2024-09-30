package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.manager.dao.Manager_FacultyAddressDAO;
import com.manage.faculty.entities.FacultyAddress;

@Service
@Qualifier("managerFacultyAddressServiceImpl")
@Transactional(transactionManager = "managerTransactionManager")
public class Manager_FacultyAddressServiceImpl implements Manager_FacultyAddressService {

    private final Manager_FacultyAddressDAO addressDAO;

    @Autowired
    public Manager_FacultyAddressServiceImpl(@Qualifier("managerFacultyAddressDAOImpl") Manager_FacultyAddressDAO manager_FacultyAddressDAO) {
        this.addressDAO = manager_FacultyAddressDAO;
    }

    @Override
    public FacultyAddress getFacultyAddressById(Long facultyAddressId) {
        return this.addressDAO.getFacultyAddressById(facultyAddressId);
    }

    @Override
    public void saveFacultyAddress(FacultyAddress facultyAddress) {
        addressDAO.saveFacultyAddress(facultyAddress);
    }

    @Override
    public void updateFacultyAddress(FacultyAddress facultyAddress) {
        addressDAO.updateFacultyAddress(facultyAddress);
    }

    @Override
    public void deleteFacultyAddress(FacultyAddress facultyAddress) {
        addressDAO.deleteFacultyAddress(facultyAddress);
    }

    @Override
    public void createFacultyAddress(FacultyAddress facultyAddress) {
        addressDAO.createFacultyAddress(facultyAddress);
    }

    @Override
    public void deleteFacultyAddressByFacultyId(Long facultyId) {
        FacultyAddress address = addressDAO.getFacultyAddressById(facultyId);
        if (address != null) {
            addressDAO.deleteFacultyAddress(address);
        }
    }

    @Override
    public FacultyAddress getFacultyAddressByFacultyId(Long facultyAddressId) {
        return addressDAO.getFacultyAddressById(facultyAddressId);
    }
}
