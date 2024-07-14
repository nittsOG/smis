package com.manage.student.service;

import com.manage.home.entities.Division;
import com.manage.student.dao.Student_DivisionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("studentTransactionManager")
public class Student_DivisionServiceImpl implements Student_DivisionService {

    private final Student_DivisionDAO studentDivisionDAO;

    @Autowired
    public Student_DivisionServiceImpl(Student_DivisionDAO studentDivisionDAO) {
        this.studentDivisionDAO = studentDivisionDAO;
    }

    @Override
    public Division getDivisionById(Long divisionId) {
        return studentDivisionDAO.findById(divisionId);
    }

    @Override
    public List<Division> getAllDivisions() {
        return studentDivisionDAO.findAll();
    }
}
