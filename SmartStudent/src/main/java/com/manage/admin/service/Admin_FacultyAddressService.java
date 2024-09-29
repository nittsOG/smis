package com.manage.admin.service;

import com.manage.faculty.entities.FacultyAddress;

public interface Admin_FacultyAddressService {
	FacultyAddress getFacultyAddressById(Long facultyAddressId);

	void saveFacultyAddress(FacultyAddress facultyAddress);

	void updateFacultyAddress(FacultyAddress facultyAddress);

	void deleteFacultyAddress(FacultyAddress facultyAddress);

	void createFacultyAddress(FacultyAddress facultyAddress);

	void deleteFacultyAddressByFacultyId(Long facultyAddressId);

	FacultyAddress getFacultyAddressByFacultyId(Long facultyAddressId);
}
