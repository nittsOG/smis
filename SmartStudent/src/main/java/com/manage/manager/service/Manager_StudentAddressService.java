package com.manage.manager.service;

import com.manage.student.entities.StudentAddress;

public interface Manager_StudentAddressService {
    StudentAddress getStudentAddressById(Long studentAddressId);
    void saveStudentAddress(StudentAddress studentAddress);
    void updateStudentAddress(StudentAddress studentAddress);
    void deleteStudentAddress(StudentAddress studentAddress);
}
