package com.manage.student.entities;

import javax.persistence.*;
import com.manage.home.entities.Semester;

@Entity
@Table(name = "student_semester")
public class StudentSemester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_semester_id")
    private Long studentSemesterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;

	public Long getStudentSemesterId() {
		return studentSemesterId;
	}

	public void setStudentSemesterId(Long studentSemesterId) {
		this.studentSemesterId = studentSemesterId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

    // Getters and Setters
}
