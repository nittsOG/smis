package com.manage.student.service;


import com.manage.student.dao.Student_SemesterResultsDAO;
import com.manage.student.dao.Student_SemesterSummaryDAO;
import com.manage.student.entities.SemesterResults;
import com.manage.student.entities.SemesterSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("studentGradesServiceImpl")
public class GradesServiceImpl implements GradesService {

    private Student_SemesterResultsDAO semesterResultsDao;
    private Student_SemesterSummaryDAO semesterSummaryDao;
    
    
    @Autowired
    public GradesServiceImpl(@Qualifier("studentSemesterResultsDAOImpl")Student_SemesterResultsDAO semesterResultsDao, @Qualifier("studentSemesterSummaryDAOImpl")Student_SemesterSummaryDAO semesterSummaryDao) {
		super();
		this.semesterResultsDao = semesterResultsDao;
		this.semesterSummaryDao = semesterSummaryDao;
	}

	@Override
    public List<SemesterResults> getResultsByStudentId(Long studentId) {
        return semesterResultsDao.findResultsByStudentId(studentId);
    }

    @Override
    public List<SemesterSummary> getSummariesByStudentId(Long studentId) {
        return semesterSummaryDao.findSummariesByStudentId(studentId);
    }
}
