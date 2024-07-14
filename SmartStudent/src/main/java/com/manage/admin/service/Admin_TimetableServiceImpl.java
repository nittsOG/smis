package com.manage.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.admin.dao.Admin_TimetableDAO;
import com.manage.home.entities.Timetable;

@Service
@Qualifier("adminTimetableServiceImpl")
@Transactional(transactionManager = "adminTransactionManager")
public class Admin_TimetableServiceImpl implements Admin_TimetableService {

    private final Admin_TimetableDAO timetableDao;

    @Autowired
    public Admin_TimetableServiceImpl(@Qualifier("adminTimetableDAOImpl") Admin_TimetableDAO timetableDao) {
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
}
