package com.manage.home.entities;

import javax.persistence.*;
import java.util.List;
import com.manage.student.entities.StudentSemester;

@Entity
@Table(name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id")
    private Long semesterId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "duration")
    private int duration;

    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentSemester> studentSemesters;

    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SemesterSubject> semesterSubjects;

	public Long getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(Long semesterId) {
		this.semesterId = semesterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<StudentSemester> getStudentSemesters() {
		return studentSemesters;
	}

	public void setStudentSemesters(List<StudentSemester> studentSemesters) {
		this.studentSemesters = studentSemesters;
	}

	public List<SemesterSubject> getSemesterSubjects() {
		return semesterSubjects;
	}

	public void setSemesterSubjects(List<SemesterSubject> semesterSubjects) {
		this.semesterSubjects = semesterSubjects;
	}

    // Getters and Setters
}
