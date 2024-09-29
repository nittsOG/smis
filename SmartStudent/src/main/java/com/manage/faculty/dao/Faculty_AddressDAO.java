package com.manage.faculty.dao;

import com.manage.faculty.entities.FacultyAddress;

public interface Faculty_AddressDAO {

	FacultyAddress getFacultyAddressById(Long id);

	void saveAddress(FacultyAddress address);

	void deleteFacultyAddress(Long id);

}
