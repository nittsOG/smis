package com.manage.student.service;

import com.manage.home.entities.Division;
import java.util.List;

public interface Student_DivisionService {
    Division getDivisionById(Long divisionId);
    List<Division> getAllDivisions();
}
