package com.manage.manager.dao;

import java.util.List;
import com.manage.home.entities.Timetable;

public interface Manager_TimetableDAO {
    void save(Timetable timetable);
    void update(Timetable timetable);
    void delete(Timetable timetable);
    Timetable findById(Long id);
    List<Timetable> findAll();
}
