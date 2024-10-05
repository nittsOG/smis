package com.manage.student.service;

import com.manage.student.entities.Backlog;
import com.manage.student.entities.SemesterResults;
import com.manage.student.entities.SemesterSummary;
import java.util.List;

public interface GradesService {
    List<SemesterResults> getResultsByStudentId(Long studentId);
    List<SemesterSummary> getSummariesByStudentId(Long studentId);
	List<Backlog> getBacklogsByStudentId(Long studentId);
}
