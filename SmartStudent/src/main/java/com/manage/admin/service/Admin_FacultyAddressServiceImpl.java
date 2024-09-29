package com.manage.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.admin.dao.Admin_FacultyAddressDAO;
import com.manage.faculty.entities.FacultyAddress;

@Service
@Qualifier("adminFacultyAddressServiceImpl")
@Transactional(transactionManager = "adminTransactionManager")
public class Admin_FacultyAddressServiceImpl implements Admin_FacultyAddressService{

	private final Admin_FacultyAddressDAO addressDAO;
	
	@Autowired
	public Admin_FacultyAddressServiceImpl(@Qualifier("adminFacultyAddressDAOImpl")Admin_FacultyAddressDAO admin_FacultyAddressDAO) {
		this.addressDAO = admin_FacultyAddressDAO;
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
		if(address != null) {
			addressDAO.deleteFacultyAddress(address);
		}
	}

	@Override
	public FacultyAddress getFacultyAddressByFacultyId(Long facultyAddressId) {
		return addressDAO.getFacultyAddressByFacultytId(facultyAddressId);
	}

}
