package com.manage.manager.dao;

import com.manage.manager.entities.Manager;

public interface ManagerDAO {
    Manager getManagerByUsername(String username);
    Manager getManagerById(Long id);
}
