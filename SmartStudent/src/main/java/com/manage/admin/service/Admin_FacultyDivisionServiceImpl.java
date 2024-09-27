package com.manage.admin.service;

import com.manage.faculty.entities.FacultyDivision;
import com.manage.admin.dao.Admin_FacultyDivisionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("adminFacultyDivisionServiceImpl")
public class Admin_FacultyDivisionServiceImpl implements Admin_FacultyDivisionService {

	private final Admin_FacultyDivisionDAO adminFacultyDivisionDAO;

	@Autowired
	public Admin_FacultyDivisionServiceImpl(
			@Qualifier("adminFacultyDivisionDAOImpl") Admin_FacultyDivisionDAO adminFacultyDivisionDAO) {
		this.adminFacultyDivisionDAO = adminFacultyDivisionDAO;
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public void saveFacultyDivision(FacultyDivision facultyDivision) {
		adminFacultyDivisionDAO.saveFacultyDivision(facultyDivision);
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public void updateFacultyDivision(FacultyDivision facultyDivision) {
		adminFacultyDivisionDAO.updateFacultyDivision(facultyDivision);
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public void deleteFacultyDivision(Long facultyDivisionId) {
		adminFacultyDivisionDAO.deleteFacultyDivision(facultyDivisionId);
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public FacultyDivision getFacultyDivisionById(Long facultyDivisionId) {
	    FacultyDivision facultyDivision = adminFacultyDivisionDAO.getFacultyDivisionById(facultyDivisionId);
	    // Initialize lazy properties
	    if (facultyDivision != null) {
	        if (facultyDivision.getDivision() != null) {
	            // Access the division and department properties to initialize them
	            facultyDivision.getDivision().getName(); 
	            facultyDivision.getDivision().getDepartment().getName(); 
	        }
	    }
	    return facultyDivision;
	}


	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public List<FacultyDivision> getAllFacultyDivisions() {
		List<FacultyDivision> facultyDivisions = adminFacultyDivisionDAO.getAllFacultyDivisions();
		for (FacultyDivision facultyDivision : facultyDivisions) {
			// Initialize lazy property
			if (facultyDivision.getFaculty() != null) {
				facultyDivision.getFaculty().getUsername(); // Access to initialize
			}
		}
		return facultyDivisions;
	}

	@Override
	@Transactional(transactionManager = "adminTransactionManager")
	public List<FacultyDivision> getFacultyDivisionsByFacultyId(Long facultyId) {
		List<FacultyDivision> facultyDivisions = adminFacultyDivisionDAO.getFacultyDivisionsByFacultyId(facultyId);
		for (FacultyDivision facultyDivision : facultyDivisions) {
			// Initialize lazy-loaded properties
			if (facultyDivision.getFaculty() != null) {
				facultyDivision.getFaculty().getUsername(); // Initialize
			}
		}
		return facultyDivisions;
	}

}
