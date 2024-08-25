package com.manage.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.admin.dao.AdminDAO;
import com.manage.admin.entities.Admin;

@Service
@Qualifier("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

	private final AdminDAO adminDAO;

	@Autowired
	public AdminServiceImpl(@Qualifier("adminDAOImpl") AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}


	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public boolean validateAdmin(Long id, String password) {
		Admin admin = adminDAO.getAdminById(id);
		return admin != null && admin.getPassword().equals(password);
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public Admin getAdminByUsername(String username) {
		return adminDAO.getAdminByUsername(username);
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public Admin getAdminById(Long id) {
		return adminDAO.getAdminById(id);
	}

}
