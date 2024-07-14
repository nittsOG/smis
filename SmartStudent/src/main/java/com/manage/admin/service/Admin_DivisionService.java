package com.manage.admin.service;


import java.util.List;

import com.manage.home.entities.Division;

public interface Admin_DivisionService {

    public Division getDivisionById(Long id);
    public void saveDivision(Division division);
    public void updateDivision(Division division);
    public void deleteDivision(Division division);
    public List<Division> getAllDivisions();
   
}
