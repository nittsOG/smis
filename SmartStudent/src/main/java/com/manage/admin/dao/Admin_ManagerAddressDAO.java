package com.manage.admin.dao;

import com.manage.manager.entities.ManagerAddress;
import java.util.List;

public interface Admin_ManagerAddressDAO {
    ManagerAddress getManagerAddressById(Long managerAddressId);
    void saveManagerAddress(ManagerAddress managerAddress);
    void updateManagerAddress(ManagerAddress managerAddress);
    void deleteManagerAddress(ManagerAddress managerAddress);
    List<ManagerAddress> getAllManagerAddresses();
}
