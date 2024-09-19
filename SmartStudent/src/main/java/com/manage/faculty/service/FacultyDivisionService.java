package com.manage.faculty.service;

import java.util.List;
import com.manage.home.entities.Division;

public interface FacultyDivisionService {

    List<Division> getDivisionsByFacultyId(Long facultyId);

    Division getDivisionById(Long divisionId);

    void saveDivision(Division division);

    void updateDivision(Division division);

    void deleteDivision(Division division);
}
