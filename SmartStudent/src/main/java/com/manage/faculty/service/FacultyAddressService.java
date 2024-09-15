package com.manage.faculty.service;

import com.manage.faculty.entities.FacultyAddress;

public interface FacultyAddressService {
    FacultyAddress getAddressById(int id);
    void saveAddress(FacultyAddress address);
    void deleteAddress(int id);
}
