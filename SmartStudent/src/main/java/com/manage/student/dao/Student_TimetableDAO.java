package com.manage.student.dao;

import com.manage.home.entities.Division;
import com.manage.home.entities.Timetable;
import java.util.List;

public interface Student_TimetableDAO {
    Timetable findById(Long id);
    List<Timetable> findAll();
	List<Timetable> getTimetableByDivision(Division division);
    
}
