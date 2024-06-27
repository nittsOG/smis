package com.manage.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.faculty.dao.FacultyDAO;
import com.manage.faculty.entities.Faculty;

@Service
public class FacultyServiceImpl implements FacultyService {
    
    private final FacultyDAO facultyDAO;

    @Autowired
    public FacultyServiceImpl(FacultyDAO facultyDAO) {
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
        return facultyDAO.getFacultyById(id);
    }

//    @Override
//    @Transactional(transactionManager = "facultyTransactionManager")
//    public Faculty getFacultyByEmail(String email) {
//        return facultyDAO.getFacultyByEmail(email);
//    }
}
