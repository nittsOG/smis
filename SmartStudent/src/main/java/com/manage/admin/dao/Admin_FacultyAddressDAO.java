package com.manage.admin.dao;

import com.manage.faculty.entities.FacultyAddress;

public interface Admin_FacultyAddressDAO {
	FacultyAddress getFacultyAddressById(Long facultyAddressId);

	void saveFacultyAddress(FacultyAddress facultyAddress);

	void updateFacultyAddress(FacultyAddress facultyAddress);

	void deleteFacultyAddress(FacultyAddress facultyAddress);

	void deleteFacultyAddressById(long facultyAddressId);

	void createFacultyAddress(FacultyAddress facultyAddress);

	FacultyAddress getFacultyAddressByFacultytId(Long facultyId);
}
