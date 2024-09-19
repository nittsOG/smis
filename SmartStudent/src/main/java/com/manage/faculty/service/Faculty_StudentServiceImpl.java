package com.manage.faculty.service;

import java.util.List;
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
        return facultyStudentDAO.getStudentsByDivision(divisionId);
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
}
