package com.manage.faculty.service;

import com.manage.faculty.entities.FacultyAddress;

public interface FacultyAddressService {
    FacultyAddress getAddressById(Long id);
    void saveAddress(FacultyAddress address);
    void deleteAddress(Long id);
}
