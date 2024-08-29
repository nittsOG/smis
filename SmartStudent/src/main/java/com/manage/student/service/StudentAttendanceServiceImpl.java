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

    // Corrected method for attendance summary
    public Map<String, Map<String, Object>> getAttendanceSummary(Long studentId, Long semesterId) {
        List<Attendance> attendanceList = attendanceDao.findAttendanceByStudentAndSemester(studentId, semesterId);

        // Map to store attendance data for each subject
        Map<String, Map<String, Object>> summary = new HashMap<>();

        // Iterate over each attendance record
        for (Attendance attendance : attendanceList) {
            String subjectName = attendance.getSession().getSubject().getName();
            String subjectCode = attendance.getSession().getSubject().getCode();

            // Check if the subject is already in the summary map
            Map<String, Object> subjectSummary = summary.get(subjectCode);
            if (subjectSummary == null) {
                // If not, initialize it
                subjectSummary = new HashMap<>();
                subjectSummary.put("subjectName", subjectName);
                subjectSummary.put("subjectCode", subjectCode);
                subjectSummary.put("totalPresent", 0);
                subjectSummary.put("totalAbsent", 0);
                summary.put(subjectCode, subjectSummary);
            }

            // Update the present/absent counts for the subject
            int totalPresent = (int) subjectSummary.get("totalPresent");
            int totalAbsent = (int) subjectSummary.get("totalAbsent");

            if (attendance.getStatus() == AttendanceStatus.PRESENT) {
                totalPresent++;
            } else if (attendance.getStatus() == AttendanceStatus.ABSENT) {
                totalAbsent++;
            }

            // Store the updated counts back into the map
            subjectSummary.put("totalPresent", totalPresent);
            subjectSummary.put("totalAbsent", totalAbsent);
        }

        // After counting, calculate the percentage for each subject
        for (Map.Entry<String, Map<String, Object>> entry : summary.entrySet()) {
            Map<String, Object> subjectSummary = entry.getValue();
            int totalPresent = (int) subjectSummary.get("totalPresent");
            int totalAbsent = (int) subjectSummary.get("totalAbsent");

            // Calculate the attendance percentage
            int totalClasses = totalPresent + totalAbsent;
            double attendancePercentage = (totalClasses == 0) ? 0 : ((double) totalPresent / totalClasses) * 100;
            subjectSummary.put("attendancePercentage", attendancePercentage);
        }

        return summary;
    }
}
