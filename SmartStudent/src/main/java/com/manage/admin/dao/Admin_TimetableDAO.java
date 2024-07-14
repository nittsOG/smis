package com.manage.admin.dao;

import java.util.List;

import com.manage.home.entities.Timetable;

public interface Admin_TimetableDAO {

    public void save(Timetable timetable);
    public void update(Timetable timetable);
    public void delete(Timetable timetable);
    public Timetable findById(Long id);
    public List<Timetable> findAll();
}
