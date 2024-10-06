package com.manage.faculty.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.dao.FacultyDAO;
import com.manage.faculty.entities.Faculty;
import com.manage.faculty.entities.FacultyAddress;

@Service
@Qualifier("facultyServiceImpl")
public class FacultyServiceImpl implements FacultyService {

    private final FacultyDAO facultyDAO;

    @Autowired
    public FacultyServiceImpl(@Qualifier("facultyDAOImpl") FacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public boolean validateFaculty(Long id, String password) {
        Faculty faculty = facultyDAO.getFacultyById(id);
        return faculty != null && faculty.getPassword().equals(password);
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public Faculty getFacultyByUsername(String username) {
        return facultyDAO.getFacultyByUsername(username);
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public Faculty getFacultyById(Long id) {
    	Faculty faculty= facultyDAO.getFacultyById(id);
    	// Initialize lazy-loaded facultyAddress
        Hibernate.initialize(faculty.getFacultyAddress());
        return faculty;
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public void updateFaculty(Faculty faculty) {

        // Fetch the existing faculty entity from the database
        Faculty oldFaculty = facultyDAO.getFacultyById(faculty.getFacultyId());

        if (oldFaculty != null) {
            // Force initialization of the lazy-loaded faculty address
            Hibernate.initialize(oldFaculty.getFacultyAddress());

            // If the new Faculty object has a FacultyAddress
            FacultyAddress newAddress = faculty.getFacultyAddress();
            
            if (newAddress != null) {
                FacultyAddress oldAddress = oldFaculty.getFacultyAddress();
                
                // If the old address exists, update its fields
                if (oldAddress != null) {
                    oldAddress.setStreet(newAddress.getStreet());
                    oldAddress.setCity(newAddress.getCity());
                    oldAddress.setCountry(newAddress.getCountry());
                    oldAddress.setState(newAddress.getState());
                    oldAddress.setZipCode(newAddress.getZipCode());

                    // Ensure that the relationship between Faculty and FacultyAddress is correct
                    newAddress.setFaculty(oldFaculty);

                    // Explicitly update the faculty address
                    facultyDAO.updateFacultyAddress(oldAddress);  // <-- New explicit DAO method to update address
                } else {
                    // If no old address exists, assign the new one
                    oldFaculty.setFacultyAddress(newAddress);
                    newAddress.setFaculty(oldFaculty);  // Set the back reference
                    
                    // Save the new faculty address
                    facultyDAO.updateFacultyAddress(newAddress);  // <-- Save or update the address
                }
            }

            // Update the faculty entity and cascade will take care of the FacultyAddress
            facultyDAO.updateFaculty(oldFaculty);
        }
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public void changePassword(Long id, String newPassword) {
        Faculty faculty = facultyDAO.getFacultyById(id);
        if (faculty != null) {
            faculty.setPassword(newPassword);  // Set the new password
            facultyDAO.updateFaculty(faculty);  // Update the faculty in the database
        }
    }

}
