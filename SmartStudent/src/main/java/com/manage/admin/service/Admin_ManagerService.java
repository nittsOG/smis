package com.manage.admin.service;

import java.util.List;

import com.manage.manager.entities.Manager;

public interface Admin_ManagerService {
    Manager getManagerById(Long managerId);

    void saveManager(Manager manager);

    void updateManager(Manager manager);

    void deleteManager(Manager manager);
    
    void deleteManager(Long managerId);

	List<Manager> getAllManagers();

	List<Manager> getManagersByDepartment(Long departmentId);
}
