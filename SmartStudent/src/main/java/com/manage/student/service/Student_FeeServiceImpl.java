package com.manage.student.service;

import com.manage.student.entities.Fee;
import com.manage.student.dao.Student_FeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("studentTransactionManager")
@Qualifier("studentFeeServiceImpl")
public class Student_FeeServiceImpl implements Student_FeeService {

    private final Student_FeeDAO studentFeeDAO;

    @Autowired
    public Student_FeeServiceImpl(@Qualifier("studentFeeDAOImpl")Student_FeeDAO studentFeeDAO) {
        this.studentFeeDAO = studentFeeDAO;
    }

    @Override
    public Fee getFeeById(Long feeId) {
        return studentFeeDAO.getFeeById(feeId);
    }

    @Override
    public List<Fee> getAllFees() {
        return studentFeeDAO.getAllFees();
    }

	@Override
	public List<Fee> getAllFeesOfStudent(Long StudentId) {
		return studentFeeDAO.getAllFeesOfStudent(StudentId);
	}
	
}
