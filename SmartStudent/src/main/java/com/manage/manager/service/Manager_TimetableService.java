package com.manage.manager.service;

import com.manage.home.entities.Timetable;
import java.util.List;

public interface Manager_TimetableService {
    void saveTimetable(Timetable timetable);
    void updateTimetable(Timetable timetable);
    void deleteTimetable(Timetable timetable);
    Timetable getTimetableById(Long timetableId);
    List<Timetable> getAllTimetables();
}
