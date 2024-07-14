package com.manage.manager.dao;

import com.manage.student.entities.StudentAddress;

public interface Manager_StudentAddressDAO {
    StudentAddress getStudentAddressById(Long studentAddressId);
    void saveStudentAddress(StudentAddress studentAddress);
    void updateStudentAddress(StudentAddress studentAddress);
    void deleteStudentAddress(StudentAddress studentAddress);
}
