package com.manage.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.home.entities.Attendance;
import com.manage.home.entities.AttendanceStatus;
import com.manage.student.dao.Student_AttendanceDao;

@Service
@Qualifier("studentAttendanceServiceImpl")
@Transactional("studentTransactionManager")
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    private final Student_AttendanceDao attendanceDao;

    @Autowired
    public StudentAttendanceServiceImpl(@Qualifier("studentAttendanceDAOImpl") Student_AttendanceDao attendanceDao) {
        this.attendanceDao = attendanceDao;
    }

    @Override
    public Attendance findById(Long id) {
        return attendanceDao.findById(id);
    }

    // Additional methods can be added as needed
    
    
    public Map<String, Object> getAttendanceSummary(Long studentId, Long semesterId) {
        List<Attendance> attendanceList = attendanceDao.findAttendanceByStudentAndSemester(studentId, semesterId);

        Map<String, Object> summary = new HashMap<>();

        for (Attendance attendance : attendanceList) {
            String subjectName = attendance.getSession().getSubject().getName();
            String subjectCode = attendance.getSession().getSubject().getCode();

            int totalPresent = 0;
            int totalAbsent = 0;

            if (attendance.getStatus() == AttendanceStatus.PRESENT) {
                totalPresent++;
            } else if (attendance.getStatus() == AttendanceStatus.ABSENT) {
                totalAbsent++;
            }

            // Calculate the percentage
            int totalClasses = totalPresent + totalAbsent;
            double attendancePercentage = (totalClasses == 0) ? 0 : ((double) totalPresent / totalClasses) * 100;

            Map<String, Object> subjectSummary = new HashMap<>();
            subjectSummary.put("subjectName", subjectName);
            subjectSummary.put("subjectCode", subjectCode);
            subjectSummary.put("totalPresent", totalPresent);
            subjectSummary.put("totalAbsent", totalAbsent);
            subjectSummary.put("attendancePercentage", attendancePercentage);

            summary.put(subjectCode, subjectSummary);
        }

        return summary;
    }
}
