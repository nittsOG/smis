package com.manage.student.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Backlog")
@IdClass(Backlog.IdClass.class)
public class Backlog {

    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Id
    @Column(name = "subject_code", length = 20)
    private String subjectCode;

    @Id
    @Column(name = "semester")
    private Integer semester;

    @Column(name = "backlog_status", length = 50)
    private String backlogStatus;

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getBacklogStatus() {
        return backlogStatus;
    }

    public void setBacklogStatus(String backlogStatus) {
        this.backlogStatus = backlogStatus;
    }

    @Embeddable
    public static class IdClass implements Serializable {
        private Long studentId;
        private String subjectCode;
        private Integer semester;

        // Default constructor
        public IdClass() {}

        // Parameterized constructor
        public IdClass(Long studentId, String subjectCode, Integer semester) {
            this.studentId = studentId;
            this.subjectCode = subjectCode;
            this.semester = semester;
        }

        // Getters and Setters
        public Long getStudentId() {
            return studentId;
        }

        public void setStudentId(Long studentId) {
            this.studentId = studentId;
        }

        public String getSubjectCode() {
            return subjectCode;
        }

        public void setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
        }

        public Integer getSemester() {
            return semester;
        }

        public void setSemester(Integer semester) {
            this.semester = semester;
        }

        // hashCode and equals methods
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IdClass idClass = (IdClass) o;
            return Objects.equals(studentId, idClass.studentId) &&
                   Objects.equals(subjectCode, idClass.subjectCode) &&
                   Objects.equals(semester, idClass.semester);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, subjectCode, semester);
        }
    }
}
