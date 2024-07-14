package com.manage.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.faculty.dao.Faculty_SemesterDAO;
import com.manage.home.entities.Semester;

@Service
@Transactional("facultyTransactionManager")
public class FacultySemesterServiceImpl implements FacultySemesterService {

    private final Faculty_SemesterDAO facultySemesterDAO;

    @Autowired
    public FacultySemesterServiceImpl(@Qualifier("facultySemesterDAOImpl") Faculty_SemesterDAO facultySemesterDAO) {
        this.facultySemesterDAO = facultySemesterDAO;
    }

    @Override
    public Semester getSemesterById(Long semesterId) {
        return facultySemesterDAO.getSemesterById(semesterId);
    }

    @Override
    public void saveSemester(Semester semester) {
        facultySemesterDAO.saveSemester(semester);
    }

    @Override
    public void updateSemester(Semester semester) {
        facultySemesterDAO.updateSemester(semester);
    }

    @Override
    public void deleteSemester(Semester semester) {
        facultySemesterDAO.deleteSemester(semester);
    }
}
