package com.manage.student.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Backlog")
public class Backlog {

    @Embeddable
    public static class IdClass implements Serializable {
        private Integer studentId;
        private String subjectCode;
        private Integer semester;

        // Default constructor
        public IdClass() {
        }

        // Parameterized constructor
        public IdClass(Integer studentId, String subjectCode, Integer semester) {
            this.studentId = studentId;
            this.subjectCode = subjectCode;
            this.semester = semester;
        }

        // Getters and Setters
        public Integer getStudentId() {
            return studentId;
        }

        public void setStudentId(Integer studentId) {
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

    @EmbeddedId
    private IdClass id;

    @Column(name = "backlog_status")
    private String backlogStatus;

    // Getters and Setters
    public IdClass getId() {
        return id;
    }

    public void setId(IdClass id) {
        this.id = id;
    }

    public String getBacklogStatus() {
        return backlogStatus;
    }

    public void setBacklogStatus(String backlogStatus) {
        this.backlogStatus = backlogStatus;
    }
}
