package com.manage.manager.service;

import com.manage.home.entities.Division;
import java.util.List;

public interface Manager_DivisionService {
    void saveDivision(Division division);
    void updateDivision(Division division);
    void deleteDivision(Division division);
    Division getDivisionById(Long divisionId);
    List<Division> getAllDivisions();
}
