package com.manage.admin.dao;

import com.manage.manager.entities.Manager;

public interface Admin_ManagerDAO {
    Manager getManagerById(Long managerId);
    void saveManager(Manager manager);
    void updateManager(Manager manager);
    void deleteManager(Manager manager);
}
