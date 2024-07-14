package com.manage.admin.service;

import com.manage.manager.entities.Manager;

public interface Admin_ManagerService {
    Manager getManagerById(Long managerId);

    void saveManager(Manager manager);

    void updateManager(Manager manager);

    void deleteManager(Manager manager);
}
