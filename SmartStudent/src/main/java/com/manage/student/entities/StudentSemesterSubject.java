package com.manage.student.entities;

import javax.persistence.*;
import com.manage.home.entities.Subject;

@Entity
@Table(name = "student_semester_subject")
public class StudentSemesterSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_semester_subject_id")
    private Long studentSemesterSubjectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_semester_id", nullable = false)
    private StudentSemester studentSemester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    // Getters and Setters
	public Long getStudentSemesterSubjectId() {
		return studentSemesterSubjectId;
	}

	public void setStudentSemesterSubjectId(Long studentSemesterSubjectId) {
		this.studentSemesterSubjectId = studentSemesterSubjectId;
	}

	public StudentSemester getStudentSemester() {
		return studentSemester;
	}

	public void setStudentSemester(StudentSemester studentSemester) {
		this.studentSemester = studentSemester;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
