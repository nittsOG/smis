package com.manage.student.service;

import com.manage.home.entities.Division;
import com.manage.home.entities.Timetable;
import java.util.List;

public interface Student_TimetableService {
    Timetable getTimetableById(Long timetableId);
    List<Timetable> getAllTimetables();
	List<Timetable> getTimetableForDivision(Division division);
}
