package com.manage.manager.service;

import com.manage.manager.dao.Manager_StudentDAO;
import com.manage.student.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("managerStudentServiceImpl")
public class Manager_StudentServiceImpl implements Manager_StudentService {

    private final Manager_StudentDAO managerStudentDAO;

    @Autowired
    public Manager_StudentServiceImpl(@Qualifier("managerStudentDAOImpl") Manager_StudentDAO managerStudentDAO) {
        this.managerStudentDAO = managerStudentDAO;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public Student getStudentById(Long studentId) {
        Student student = managerStudentDAO.getStudentById(studentId);
        initializeStudent(student);
        return student;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void saveStudent(Student student) {
        managerStudentDAO.saveStudent(student);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void updateStudent(Student student) {
        managerStudentDAO.updateStudent(student);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public void deleteStudent(Long studentId) {
        Student student = getStudentById(studentId);
        managerStudentDAO.deleteStudent(student);
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Student> getAllStudents() {
        List<Student> students = managerStudentDAO.getAllStudents();
        students.forEach(this::initializeStudent);
        return students;
    }

    @Override
    @Transactional(transactionManager = "managerTransactionManager")
    public List<Student> getStudentsByDivision(String divisionName) {
        List<Student> students = managerStudentDAO.getStudentsByDivision(divisionName);
        students.forEach(this::initializeStudent);
        return students;
    }

    private void initializeStudent(Student student) {
        if (student != null && student.getDivision() != null) {
            student.getDivision().getName();
            if (student.getDivision().getDepartment() != null) {
                student.getDivision().getDepartment().getName();
            }
        }
    }

	@Override
	public void deleteStudent(Student student) {
		this.deleteStudent(student.getStudentId());
	}
	
    @Override
    @Transactional(transactionManager = "adminTransactionManager")
    public List<Student> getStudentsByDepartment(String departmentName) {
        List<Student> students = managerStudentDAO.getStudentsByDepartment(departmentName);
        students.forEach(this::initializeStudent);
        return students;
    }
}
