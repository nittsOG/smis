package com.manage.admin.service;

import java.util.List;

import com.manage.home.entities.Timetable;

public interface Admin_TimetableService {

    public Timetable getTimetableById(Long id);
    public void saveTimetable(Timetable timetable);
    public void updateTimetable(Timetable timetable);
    public void deleteTimetable(Long id);   
    public List<Timetable> getAllTimetables();
	List<Timetable> getFilteredTimetables(Long subjectId, Long facultyId, Long divisionId);
	void deleteTimetable(Timetable timetable);

}
