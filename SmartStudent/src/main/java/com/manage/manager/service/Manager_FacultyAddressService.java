package com.manage.manager.service;

import com.manage.faculty.entities.FacultyAddress;

public interface Manager_FacultyAddressService {

	FacultyAddress getFacultyAddressById(Long facultyAddressId);

	void saveFacultyAddress(FacultyAddress facultyAddress);

	void updateFacultyAddress(FacultyAddress facultyAddress);

	void deleteFacultyAddress(FacultyAddress facultyAddress);

	void createFacultyAddress(FacultyAddress facultyAddress);

	void deleteFacultyAddressByFacultyId(Long facultyId);

	FacultyAddress getFacultyAddressByFacultyId(Long facultyAddressId);

}
