package com.manage.admin.dao;

import com.manage.student.entities.StudentAddress;

public interface Admin_StudentAddressDAO {
    StudentAddress getStudentAddressById(Long studentAddressId);
    void saveStudentAddress(StudentAddress studentAddress);
    void updateStudentAddress(StudentAddress studentAddress);
    void deleteStudentAddress(StudentAddress studentAddress);
    void deleteStudentAddressById(long studentAddressId);
	void createStudentAddress(StudentAddress studentAddress);
	StudentAddress getStudentAddressByStudentId(Long studentId);
}
