package com.manage.admin.service;

import com.manage.manager.entities.ManagerAddress;
import java.util.List;

public interface Admin_ManagerAddressService {
    ManagerAddress getManagerAddressById(Long managerAddressId);
    void saveManagerAddress(ManagerAddress managerAddress);
    void updateManagerAddress(ManagerAddress managerAddress);
    void deleteManagerAddress(ManagerAddress managerAddress);
    List<ManagerAddress> getAllManagerAddresses();
}
