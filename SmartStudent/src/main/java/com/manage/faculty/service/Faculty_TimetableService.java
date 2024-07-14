package com.manage.faculty.service;

import com.manage.home.entities.Timetable;
import java.util.List;

public interface Faculty_TimetableService {
    Timetable getTimetableById(Long timetableId);
    List<Timetable> getAllTimetables();
}
