package com.manage.faculty.entities;

import javax.persistence.*;

import com.manage.faculty.entities.Faculty;
import com.manage.home.entities.Division;

@Entity
@Table(name = "faculty_division")
public class FacultyDivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_division_id")
    private Long facultyDivisionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id")
    private Division division;

    // Getters and Setters

    public Long getFacultyDivisionId() {
        return facultyDivisionId;
    }

    public void setFacultyDivisionId(Long facultyDivisionId) {
        this.facultyDivisionId = facultyDivisionId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
