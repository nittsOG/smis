package com.manage.faculty.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @Column(name = "is_fr", nullable = false)
    private boolean isFr;

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

    public boolean isFr() {
        return isFr;
    }

    public void setFr(boolean isFr) {
        this.isFr = isFr;
    }
}
