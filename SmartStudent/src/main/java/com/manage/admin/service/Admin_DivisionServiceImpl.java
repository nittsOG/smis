package com.manage.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.admin.dao.Admin_DivisionDAO;
import com.manage.home.entities.Division;

@Service
@Qualifier("adminDivisionServiceImpl")
@Transactional(transactionManager = "adminTransactionManager")
public class Admin_DivisionServiceImpl implements Admin_DivisionService {

	private final Admin_DivisionDAO divisionDao;

	@Autowired
	public Admin_DivisionServiceImpl(@Qualifier("adminDivisionDAOImpl") Admin_DivisionDAO divisionDao) {
		this.divisionDao = divisionDao;
	}

	@Override
	public Division getDivisionById(Long id) {
		return divisionDao.findById(id);
	}

	@Override
	public void saveDivision(Division division) {
		divisionDao.save(division);
	}

	@Override
	public void updateDivision(Division division) {
	    // Ensure that the division exists before updating it
	    Division existingDivision = divisionDao.findById(division.getDivisionId());
	    if (existingDivision != null) {
	        divisionDao.update(division); // This should use a Hibernate session or entity manager to update
	    }
	}


	@Override
	public void deleteDivision(Division division) {
		divisionDao.delete(division);
	}

	@Override
	public List<Division> getAllDivisions() {
		return divisionDao.findAll();
	}

	@Override
	public void deletebyId(Long id) {
		this.deleteDivision(this.getDivisionById(id));
	}

	@Override
	public List<Division> getDivisionsByDepartment(Long departmentId) {
		return divisionDao.findByDepartmentId(departmentId);
	}

}
