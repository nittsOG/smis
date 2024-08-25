package com.manage.student.dao;

import java.util.List;

import com.manage.home.entities.Attendance;

public interface Student_AttendanceDao {

    Attendance findById(Long id);

	List<Attendance> findAttendanceByStudentAndSemester(Long studentId, Long semesterId);

    // Add more methods for CRUD operations as needed

}
