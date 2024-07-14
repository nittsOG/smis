package com.manage.student.service;

import com.manage.home.entities.Timetable;
import com.manage.student.dao.Student_TimetableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("studentTransactionManager")
public class Student_TimetableServiceImpl implements Student_TimetableService {

    private final Student_TimetableDAO studentTimetableDAO;

    @Autowired
    public Student_TimetableServiceImpl(Student_TimetableDAO studentTimetableDAO) {
        this.studentTimetableDAO = studentTimetableDAO;
    }

    @Override
    public Timetable getTimetableById(Long timetableId) {
        return studentTimetableDAO.findById(timetableId);
    }

    @Override
    public List<Timetable> getAllTimetables() {
        return studentTimetableDAO.findAll();
    }
}
