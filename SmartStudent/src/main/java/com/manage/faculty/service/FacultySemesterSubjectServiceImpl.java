package com.manage.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.faculty.dao.Faculty_SemesterSubjectDAO;
import com.manage.home.entities.SemesterSubject;

@Service
@Transactional("facultyTransactionManager")
public class FacultySemesterSubjectServiceImpl implements FacultySemesterSubjectService {

    private final Faculty_SemesterSubjectDAO facultySemesterSubjectDAO;

    @Autowired
    public FacultySemesterSubjectServiceImpl(@Qualifier("facultySemesterSubjectDAOImpl") Faculty_SemesterSubjectDAO facultySemesterSubjectDAO) {
        this.facultySemesterSubjectDAO = facultySemesterSubjectDAO;
    }

    @Override
    public SemesterSubject getSemesterSubjectById(Long semesterSubjectId) {
        return facultySemesterSubjectDAO.getSemesterSubjectById(semesterSubjectId);
    }

    @Override
    public void saveSemesterSubject(SemesterSubject semesterSubject) {
        facultySemesterSubjectDAO.saveSemesterSubject(semesterSubject);
    }

    @Override
    public void updateSemesterSubject(SemesterSubject semesterSubject) {
        facultySemesterSubjectDAO.updateSemesterSubject(semesterSubject);
    }

    @Override
    public void deleteSemesterSubject(SemesterSubject semesterSubject) {
        facultySemesterSubjectDAO.deleteSemesterSubject(semesterSubject);
    }
}
