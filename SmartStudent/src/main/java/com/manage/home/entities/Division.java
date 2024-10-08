package com.manage.home.entities;

import javax.persistence.*;
import com.manage.faculty.entities.FacultyDivision;
import com.manage.student.entities.Student;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "division")
public class Division {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long divisionId;

    @Column(name = "name", nullable = false , unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id" , nullable = false)
    private Department department;
    
    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Student> students;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<FacultyDivision> facultyDivisions;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Timetable> timetables;

    // Getters and Setters

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<FacultyDivision> getFacultyDivisions() {
        return facultyDivisions;
    }

    public void setFacultyDivisions(List<FacultyDivision> facultyDivisions) {
        this.facultyDivisions = facultyDivisions;
    }

    public Set<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(Set<Timetable> timetables) {
        this.timetables = timetables;
    }
}
