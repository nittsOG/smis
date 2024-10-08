package com.manage.admin.service;

import com.manage.admin.entities.Admin;

public interface AdminService {
    boolean validateAdmin(Long id, String password);
    Admin getAdminByUsername(String username);
    Admin getAdminById(Long id);
}
