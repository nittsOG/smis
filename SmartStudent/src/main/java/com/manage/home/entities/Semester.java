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

    @Column(name = "start_date") // Added startDate
    private java.sql.Date startDate;

    @Column(name = "end_date") // Added endDate
    private java.sql.Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

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

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.sql.Date endDate) {
        this.endDate = endDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
}
