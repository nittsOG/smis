package com.manage.student.service;

import com.manage.home.entities.Division;
import com.manage.home.entities.Timetable;
import com.manage.student.dao.Student_TimetableDAO;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("studentTransactionManager")
@Qualifier("studentTimetableServiceImpl")
public class Student_TimetableServiceImpl implements Student_TimetableService {

    private final Student_TimetableDAO studentTimetableDAO;

    @Autowired
    public Student_TimetableServiceImpl(@Qualifier("studentTimetableDAOImpl")Student_TimetableDAO studentTimetableDAO) {
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

    @Override
    public List<Timetable> getTimetableForDivision(Division division) {
        List<Timetable> timetables = studentTimetableDAO.getTimetableByDivision(division);

        // Initialize lazy-loaded fields here
        for (Timetable timetable : timetables) {
            Hibernate.initialize(timetable.getSubject());
            Hibernate.initialize(timetable.getSubject().getName());
            Hibernate.initialize(timetable.getFaculty());
            Hibernate.initialize(timetable.getFaculty().getUsername());
        }

        return timetables;
    }
}
