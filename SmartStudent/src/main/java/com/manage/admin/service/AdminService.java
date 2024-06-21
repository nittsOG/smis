package com.manage.admin.service;

import com.manage.admin.entities.Admin;

public interface AdminService {
    boolean validateAdmin(String username, String password);
}
