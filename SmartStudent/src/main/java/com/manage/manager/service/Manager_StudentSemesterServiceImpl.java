package com.manage.manager.service;

import com.manage.manager.dao.Manager_StudentSemesterDAO;
import com.manage.student.entities.StudentSemester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerStudentSemesterServiceImpl")
public class Manager_StudentSemesterServiceImpl implements Manager_StudentSemesterService {

    private final Manager_StudentSemesterDAO managerStudentSemesterDAO;

    @Autowired
    public Manager_StudentSemesterServiceImpl(@Qualifier("managerStudentSemesterDAOImpl") Manager_StudentSemesterDAO managerStudentSemesterDAO) {
        this.managerStudentSemesterDAO = managerStudentSemesterDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public StudentSemester getStudentSemesterById(Long studentSemesterId) {
        StudentSemester studentSemester = managerStudentSemesterDAO.getStudentSemesterById(studentSemesterId);
        initializeStudentSemester(studentSemester);
        return studentSemester;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveStudentSemester(StudentSemester studentSemester) {
        managerStudentSemesterDAO.saveStudentSemester(studentSemester);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateStudentSemester(StudentSemester studentSemester) {
        managerStudentSemesterDAO.updateStudentSemester(studentSemester);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteStudentSemester(Long studentSemesterId) {
        StudentSemester studentSemester = getStudentSemesterById(studentSemesterId);
        if (studentSemester != null) {
            managerStudentSemesterDAO.deleteStudentSemester(studentSemester);
        }
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<StudentSemester> getAllStudentSemesters() {
        List<StudentSemester> studentSemesters = managerStudentSemesterDAO.getAllStudentSemesters();
        studentSemesters.forEach(this::initializeStudentSemester);
        return studentSemesters;
    }

    private void initializeStudentSemester(StudentSemester studentSemester) {
        if (studentSemester != null) {
            if (studentSemester.getStudent() != null) {
                studentSemester.getStudent().getUsername(); // Force initialization
            }
            if (studentSemester.getSemester() != null) {
                studentSemester.getSemester().getName();
            }
        }
    }

    @Override
    public List<StudentSemester> getStudentSemestersByStudentId(Long studentId) {
        return managerStudentSemesterDAO.getStudentSemestersByStudentId(studentId);
    }

	@Override
	public void deleteStudentSemester(StudentSemester studentSemester) {
		this.deleteStudentSemester(studentSemester.getStudentSemesterId());
	}
}
