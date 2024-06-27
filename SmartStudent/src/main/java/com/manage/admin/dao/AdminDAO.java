package com.manage.admin.dao;

import com.manage.admin.entities.Admin;

public interface AdminDAO {
    Admin getAdminByUsername(String username);
    Admin getAdminById(Long id);
}
