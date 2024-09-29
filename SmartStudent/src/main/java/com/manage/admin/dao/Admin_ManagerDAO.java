package com.manage.admin.dao;

import com.manage.manager.entities.Manager;

import java.util.List;

public interface Admin_ManagerDAO {
    Manager getManagerById(Long managerId);
    void saveManager(Manager manager);
    void updateManager(Manager manager);
    void deleteManager(Manager manager);
    List<Manager> getAllManagers(); // New method to fetch all managers
	List<Manager> getManagersByDepartment(Long departmentId);
}
