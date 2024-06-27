package com.manage.manager.service;

import com.manage.manager.entities.Manager;

public interface ManagerService {
    boolean validateManager(Long id, String password);
    Manager getManagerByUsername(String username);
    Manager getManagerById(Long id);
//    Manager getManagerByEmail(String email);
}
