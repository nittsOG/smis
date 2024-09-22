package com.manage.admin.service;

import com.manage.student.entities.StudentAddress;

public interface Admin_StudentAddressService {
    StudentAddress getStudentAddressById(Long studentAddressId);

    void saveStudentAddress(StudentAddress studentAddress);

    void updateStudentAddress(StudentAddress studentAddress);

    void deleteStudentAddress(Long studentAddressId);

	void createStudentAddress(StudentAddress studentAddress);

	StudentAddress getStudentAddressByStudentId(Long studentId);

	void deleteStudentAddressByStudentId(Long studentId);
}
