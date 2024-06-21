package com.manage.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.admin.dao.AdminDAO;
import com.manage.admin.entities.Admin;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional
    public boolean validateAdmin(String username, String password) {
        Admin admin = adminDAO.getAdminByUsername(username);
        return admin != null && admin.getPassword().equals(password);
    }
}
