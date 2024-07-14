package com.manage.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.entities.Faculty;
import com.manage.manager.dao.Manager_FacultyDAO;

@Service
@Transactional("managerTransactionManager")
public class Manager_FacultyServiceImpl implements Manager_FacultyService {

    private final Manager_FacultyDAO managerFacultyDAO;

    @Autowired
    public Manager_FacultyServiceImpl(Manager_FacultyDAO managerFacultyDAO) {
        this.managerFacultyDAO = managerFacultyDAO;
    }

    @Override
    public Faculty getFacultyById(Long facultyId) {
        return managerFacultyDAO.getFacultyById(facultyId);
    }

    @Override
    public void saveFaculty(Faculty faculty) {
        managerFacultyDAO.saveFaculty(faculty);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        managerFacultyDAO.updateFaculty(faculty);
    }

    @Override
    public void deleteFaculty(Faculty faculty) {
        managerFacultyDAO.deleteFaculty(faculty);
    }
}
