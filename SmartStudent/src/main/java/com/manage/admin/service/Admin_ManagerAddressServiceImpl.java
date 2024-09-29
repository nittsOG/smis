package com.manage.admin.service;

import com.manage.admin.dao.Admin_ManagerAddressDAO;
import com.manage.manager.entities.ManagerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminManagerAddressServiceImpl")
public class Admin_ManagerAddressServiceImpl implements Admin_ManagerAddressService {

	private final Admin_ManagerAddressDAO adminManagerAddressDAO;

	@Autowired
	public Admin_ManagerAddressServiceImpl(
			@Qualifier("adminManagerAddressDAOImpl") Admin_ManagerAddressDAO adminManagerAddressDAO) {
		this.adminManagerAddressDAO = adminManagerAddressDAO;
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public ManagerAddress getManagerAddressById(Long managerAddressId) {
		ManagerAddress managerAddress = adminManagerAddressDAO.getManagerAddressById(managerAddressId);
		if (managerAddress != null) {
			if (managerAddress.getManager() != null) {
				managerAddress.getManager().getUsername(); // Initialize manager
			}
		}
		return managerAddress;
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public void saveManagerAddress(ManagerAddress managerAddress) {
		adminManagerAddressDAO.saveManagerAddress(managerAddress);
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public void updateManagerAddress(ManagerAddress managerAddress) {
		adminManagerAddressDAO.updateManagerAddress(managerAddress);
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public void deleteManagerAddress(ManagerAddress managerAddress) {
		adminManagerAddressDAO.deleteManagerAddress(managerAddress);
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public List<ManagerAddress> getAllManagerAddresses() {
		List<ManagerAddress> addresses = adminManagerAddressDAO.getAllManagerAddresses();
		for (ManagerAddress address : addresses) {
			if (address.getManager() != null) {
				address.getManager().getUsername(); // Initialize manager
			}
		}
		return addresses;
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public void deleteManagerAddressByManagerId(Long managerId) {
		adminManagerAddressDAO.deleteManagerAddressByManagerId(managerId);
	}

}
