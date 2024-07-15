package com.manage.faculty.entities;

import javax.persistence.*;

import com.manage.home.entities.Subject;

@Entity
@Table(name = "faculty_subject")
public class FacultySubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_subject_id")
    private Long facultySubjectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    // Getters and Setters

    public Long getFacultySubjectId() {
        return facultySubjectId;
    }

    public void setFacultySubjectId(Long facultySubjectId) {
        this.facultySubjectId = facultySubjectId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
