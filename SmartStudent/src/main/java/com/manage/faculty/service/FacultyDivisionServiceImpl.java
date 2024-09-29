package com.manage.faculty.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.manage.faculty.dao.Faculty_DivisionDAO;
import com.manage.home.entities.Division;

@Service
@Transactional("facultyTransactionManager")
@Qualifier("facultyDivisionServiceImpl")
public class FacultyDivisionServiceImpl implements FacultyDivisionService {

    private final Faculty_DivisionDAO facultyDivisionDAO;

    @Autowired
    public FacultyDivisionServiceImpl(@Qualifier("facultyDivisionDAOImpl") Faculty_DivisionDAO facultyDivisionDAO) {
        this.facultyDivisionDAO = facultyDivisionDAO;
    }

    @Override
    public List<Division> getDivisionsByFacultyId(Long facultyId) {
        return facultyDivisionDAO.getDivisionsByFacultyId(facultyId);
    }

    @Override
    public Division getDivisionById(Long divisionId) {
        return facultyDivisionDAO.getDivisionById(divisionId);
    }

    @Override
    public void saveDivision(Division division) {
        facultyDivisionDAO.saveDivision(division);
    }

    @Override
    public void updateDivision(Division division) {
        facultyDivisionDAO.updateDivision(division);
    }

    @Override
    public void deleteDivision(Division division) {
        facultyDivisionDAO.deleteDivision(division);
    }
}
