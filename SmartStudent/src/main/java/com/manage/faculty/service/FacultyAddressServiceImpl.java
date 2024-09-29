package com.manage.faculty.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.dao.Faculty_AddressDAO;
import com.manage.faculty.entities.FacultyAddress;

@Service
@Transactional("facultyTransactionManager")
@Qualifier("facultyAddressServiceImpl")
public class FacultyAddressServiceImpl implements FacultyAddressService {


    private Faculty_AddressDAO facultyAddressDAO;

    @Autowired
    public FacultyAddressServiceImpl(@Qualifier("facultyAddressDAOImpl")Faculty_AddressDAO facultyAddressDAO) {
		super();
		this.facultyAddressDAO = facultyAddressDAO;
	}

	@Override
    public FacultyAddress getAddressById(Long id) {
        return facultyAddressDAO.getFacultyAddressById(id);
    }

    @Override
    public void saveAddress(FacultyAddress address) {
        facultyAddressDAO.saveAddress(address);
    }

    @Override
    public void deleteAddress(Long id) {
        facultyAddressDAO.deleteFacultyAddress(id);
    }
}
