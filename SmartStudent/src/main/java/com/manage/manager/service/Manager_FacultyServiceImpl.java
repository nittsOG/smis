package com.manage.manager.service;

import com.manage.manager.dao.Manager_FacultyDAO;
import com.manage.faculty.entities.Faculty;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerFacultyServiceImpl")
public class Manager_FacultyServiceImpl implements Manager_FacultyService {

    private final Manager_FacultyDAO managerFacultyDAO;

    @Autowired
    public Manager_FacultyServiceImpl(@Qualifier("managerFacultyDAOImpl") Manager_FacultyDAO managerFacultyDAO) {
        this.managerFacultyDAO = managerFacultyDAO;
    }

    @Override
    @Transactional("managerTransactionManager")
    public void saveFaculty(Faculty faculty) {
        managerFacultyDAO.saveFaculty(faculty);
    }

    @Override
    @Transactional("managerTransactionManager")
    public void updateFaculty(Faculty faculty) {
        managerFacultyDAO.updateFaculty(faculty);
    }

    @Override
    @Transactional("managerTransactionManager")
    public void deleteFaculty(Faculty faculty) {
        managerFacultyDAO.deleteFaculty(faculty);
    }

    @Override
    @Transactional("managerTransactionManager")
    public Faculty getFacultyById(Long facultyId) {
        Faculty faculty = managerFacultyDAO.getFacultyById(facultyId);
        if (faculty != null && faculty.getDepartment() != null) {
            Hibernate.initialize(faculty.getDepartment());
        }
        return faculty;
    }

    @Override
    @Transactional("managerTransactionManager")
    public List<Faculty> getAllFaculties() {
        return managerFacultyDAO.getAllFaculties();
    }

    @Override
    @Transactional("managerTransactionManager")
    public List<Faculty> getFacultyByDepartment(String department) {
        return managerFacultyDAO.getFacultyByDepartment(department);
    }

    @Override
    @Transactional("managerTransactionManager")
    public void deleteFacultyById(Long facultyId) {
        Faculty faculty = managerFacultyDAO.getFacultyById(facultyId);
        if (faculty != null) {
            managerFacultyDAO.deleteFaculty(faculty);
        }
    }

    @Override
    @Transactional("managerTransactionManager")
    public void createFacultyById(Faculty faculty) {
        managerFacultyDAO.createFaculty(faculty);
    }
}
