package com.manage.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.manager.dao.Manager_TimetableDAO;
import com.manage.home.entities.Timetable;

@Service
@Qualifier("managerTimetableServiceImpl")
@Transactional(transactionManager = "managerTransactionManager")
public class Manager_TimetableServiceImpl implements Manager_TimetableService {

    private final Manager_TimetableDAO timetableDao;

    @Autowired
    public Manager_TimetableServiceImpl(@Qualifier("managerTimetableDAOImpl") Manager_TimetableDAO timetableDao) {
        this.timetableDao = timetableDao;
    }

    @Override
    public Timetable getTimetableById(Long id) {
        return timetableDao.findById(id);
    }

    @Override
    public void saveTimetable(Timetable timetable) {
        timetableDao.save(timetable);
    }

    @Override
    public void updateTimetable(Timetable timetable) {
        timetableDao.update(timetable);
    }

    @Override
    public void deleteTimetable(Timetable timetable) {
        timetableDao.delete(timetable);
    }

    @Override
    public List<Timetable> getAllTimetables() {
        return timetableDao.findAll();
    }

    @Override
    public List<Timetable> getFilteredTimetables(Long subjectId, Long facultyId, Long divisionId) {
        return timetableDao.findTimetablesByFilters(subjectId, facultyId, divisionId);
    }

    @Override
    public void deleteTimetable(Long id) {
        timetableDao.delete(this.getTimetableById(id));
    }
}
