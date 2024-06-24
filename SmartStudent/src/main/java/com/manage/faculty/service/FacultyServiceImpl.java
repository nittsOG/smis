package com.manage.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.dao.FacultyDAO;
import com.manage.faculty.entities.Faculty;

@Service
public class FacultyServiceImpl implements FacultyService {
    
    private FacultyDAO facultyDAO;

    @Autowired
    public FacultyServiceImpl(FacultyDAO facultyDAO) {
        super();
        this.facultyDAO = facultyDAO;
    }

    @Override
    @Transactional(transactionManager = "facultyTransactionManager")
    public boolean validateFaculty(String username, String password) {
        Faculty faculty = facultyDAO.getFacultyByUsername(username);
        return faculty != null && faculty.getPassword().equals(password);
    }
}
