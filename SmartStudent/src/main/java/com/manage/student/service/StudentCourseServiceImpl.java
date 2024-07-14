package com.manage.student.service;

import com.manage.home.entities.Course;
import com.manage.student.dao.Student_CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("studentCourseServiceImpl")
public class StudentCourseServiceImpl implements StudentCourseService {

    private final Student_CourseDao courseDao;

    @Autowired
    public StudentCourseServiceImpl(@Qualifier("studentCourseDaoImpl") Student_CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public Course findById(Long id) {
        return courseDao.findById(id);
    }

    // Implement more service methods if needed
}
