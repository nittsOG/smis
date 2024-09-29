package com.manage.home.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.manage.faculty.entities.FacultySubject;
import com.manage.student.entities.StudentSemesterSubject;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id" , nullable = false)
    private Course course;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SemesterSubject> semesterSubjects;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentSemesterSubject> studentSemesterSubjects;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sessions;
    
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacultySubject> facultySubjects;


	// Getters and Setters
    
    public List<FacultySubject> getFacultySubjects() {
        return facultySubjects;
    }

    public void setFacultySubjects(List<FacultySubject> facultySubjects) {
        this.facultySubjects = facultySubjects;
    }

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SemesterSubject> getSemesterSubjects() {
		return semesterSubjects;
	}

	public void setSemesterSubjects(List<SemesterSubject> semesterSubjects) {
		this.semesterSubjects = semesterSubjects;
	}

	public List<StudentSemesterSubject> getStudentSemesterSubjects() {
		return studentSemesterSubjects;
	}

	public void setStudentSemesterSubjects(List<StudentSemesterSubject> studentSemesterSubjects) {
		this.studentSemesterSubjects = studentSemesterSubjects;
	}


}
