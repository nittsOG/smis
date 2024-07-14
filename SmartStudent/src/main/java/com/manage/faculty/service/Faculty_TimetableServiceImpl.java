package com.manage.faculty.service;

import com.manage.home.entities.Timetable;
import com.manage.faculty.dao.Faculty_TimetableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("facultyTransactionManager")
public class Faculty_TimetableServiceImpl implements Faculty_TimetableService {

    private final Faculty_TimetableDAO facultyTimetableDAO;

    @Autowired
    public Faculty_TimetableServiceImpl(Faculty_TimetableDAO facultyTimetableDAO) {
        this.facultyTimetableDAO = facultyTimetableDAO;
    }

    @Override
    public Timetable getTimetableById(Long timetableId) {
        return facultyTimetableDAO.findById(timetableId);
    }

    @Override
    public List<Timetable> getAllTimetables() {
        return facultyTimetableDAO.findAll();
    }
}
