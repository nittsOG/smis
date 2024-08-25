package com.manage.faculty.entities;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

import com.manage.home.entities.Department;

@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "faculty_id")
	private Long facultyId;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;

	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<FacultySubject> facultySubjects;

	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<FacultyDivision> facultyDivisions;

	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FacultyAddress> facultyAddresses;

	// Getters and Setters

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<FacultySubject> getFacultySubjects() {
		return facultySubjects;
	}

	public void setFacultySubjects(Set<FacultySubject> facultySubjects) {
		this.facultySubjects = facultySubjects;
	}

	public Set<FacultyDivision> getFacultyDivisions() {
		return facultyDivisions;
	}

	public void setFacultyDivisions(Set<FacultyDivision> facultyDivisions) {
		this.facultyDivisions = facultyDivisions;
	}
}
