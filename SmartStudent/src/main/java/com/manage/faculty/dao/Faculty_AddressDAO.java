package com.manage.faculty.dao;

import com.manage.faculty.entities.FacultyAddress;

public interface Faculty_AddressDAO {

	FacultyAddress getAddressById(int id);

	void saveAddress(FacultyAddress address);

	void deleteAddress(int id);

}
