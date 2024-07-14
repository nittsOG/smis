package com.manage.manager.service;

import com.manage.home.entities.Timetable;
import com.manage.manager.dao.Manager_TimetableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("managerTransactionManager")
public class Manager_TimetableServiceImpl implements Manager_TimetableService {

    private final Manager_TimetableDAO managerTimetableDAO;

    @Autowired
    public Manager_TimetableServiceImpl(Manager_TimetableDAO managerTimetableDAO) {
        this.managerTimetableDAO = managerTimetableDAO;
    }

    @Override
    public void saveTimetable(Timetable timetable) {
        managerTimetableDAO.save(timetable);
    }

    @Override
    public void updateTimetable(Timetable timetable) {
        managerTimetableDAO.update(timetable);
    }

    @Override
    public void deleteTimetable(Timetable timetable) {
        managerTimetableDAO.delete(timetable);
    }

    @Override
    public Timetable getTimetableById(Long timetableId) {
        return managerTimetableDAO.findById(timetableId);
    }

    @Override
    public List<Timetable> getAllTimetables() {
        return managerTimetableDAO.findAll();
    }
}
