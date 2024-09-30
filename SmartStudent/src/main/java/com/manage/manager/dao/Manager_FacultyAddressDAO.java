package com.manage.manager.dao;

import com.manage.faculty.entities.FacultyAddress;

public interface Manager_FacultyAddressDAO {

	FacultyAddress getFacultyAddressById(Long facultyAddressId);

	void saveFacultyAddress(FacultyAddress facultyAddress);

	void updateFacultyAddress(FacultyAddress facultyAddress);

	void deleteFacultyAddress(FacultyAddress facultyAddress);

	FacultyAddress getFacultyAddressByFacultytId(Long facultyId);

	void createFacultyAddress(FacultyAddress facultyAddress);

	void deleteFacultyAddressById(long facultyAddressId);

}
