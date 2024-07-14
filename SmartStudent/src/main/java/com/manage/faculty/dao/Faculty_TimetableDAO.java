package com.manage.faculty.dao;

import com.manage.home.entities.Timetable;
import java.util.List;

public interface Faculty_TimetableDAO {
    Timetable findById(Long id);
    List<Timetable> findAll();
}
