package com.manage.faculty.dao;

import java.util.List;
import com.manage.home.entities.Division;

public interface Faculty_DivisionDAO {

    List<Division> getDivisionsByFacultyId(Long facultyId);

    Division getDivisionById(Long divisionId);

    void saveDivision(Division division);

    void updateDivision(Division division);

    void deleteDivision(Division division);
}
