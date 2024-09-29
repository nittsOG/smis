package com.manage.faculty.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.faculty.dao.Faculty_StudentDAO;
import com.manage.student.entities.Student;

@Service
@Transactional("facultyTransactionManager")
@Qualifier("facultyStudentServiceImpl")
public class Faculty_StudentServiceImpl implements Faculty_StudentService {

	private final Faculty_StudentDAO facultyStudentDAO;

	@Autowired
	public Faculty_StudentServiceImpl(@Qualifier("facultyStudentDAOImpl") Faculty_StudentDAO facultyStudentDAO) {
		this.facultyStudentDAO = facultyStudentDAO;
	}

	@Override
	public List<Student> getStudentsByDivision(Long divisionId) {
		List<Student> students = facultyStudentDAO.getStudentsByDivision(divisionId);
		students.forEach(this::initializeStudent);
		return students;
	}

	@Override
	public Student getStudentById(Long studentId) {
		return facultyStudentDAO.getStudentById(studentId);
	}

	@Override
	public void saveStudent(Student student) {
		facultyStudentDAO.saveStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		facultyStudentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudent(Student student) {
		facultyStudentDAO.deleteStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = facultyStudentDAO.getAllStudents();
		students.forEach(this::initializeStudent);
		return students;
	}

	private void initializeStudent(Student student) {
	    if (student != null && student.getDivision() != null) {
	        Hibernate.initialize(student.getDivision()); // Initialize Division
	        if (student.getDivision().getDepartment() != null) {
	            Hibernate.initialize(student.getDivision().getDepartment().getName()); // Initialize Department
	        }
	    }
	}


	@Override
	public List<Student> getStudentsByDivisionName(String divisionName) {
		List<Student> students = facultyStudentDAO.getStudentsByDivisionName(divisionName);
		students.forEach(this::initializeStudent);
		return students;
	}
}
