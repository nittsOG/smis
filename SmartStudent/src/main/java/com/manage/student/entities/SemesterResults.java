package com.manage.student.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "SemesterResults")
@IdClass(SemesterResults.IdClass.class)
public class SemesterResults {

    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Id
    @Column(name = "semester")
    private Integer semester;

    @Id
    @Column(name = "subject_code", length = 20)
    private String subjectCode;

    @Column(name = "subject_name", length = 100)
    private String subjectName;

    @Column(name = "credit", precision = 5, scale = 2)
    private BigDecimal credit;

    @Column(name = "grade", length = 2)
    private String grade;

    @Column(name = "grade_point", precision = 3, scale = 2)
    private BigDecimal gradePoint;

    @Column(name = "credit_point", precision = 5, scale = 2)
    private BigDecimal creditPoint;

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public BigDecimal getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(BigDecimal gradePoint) {
        this.gradePoint = gradePoint;
    }

    public BigDecimal getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(BigDecimal creditPoint) {
        this.creditPoint = creditPoint;
    }

    @Embeddable
    public static class IdClass implements Serializable {
        private Long studentId;
        private Integer semester;
        private String subjectCode;

        // Default constructor
        public IdClass() {}

        // Parameterized constructor
        public IdClass(Long studentId, Integer semester, String subjectCode) {
            this.studentId = studentId;
            this.semester = semester;
            this.subjectCode = subjectCode;
        }

        // Getters and Setters
        public Long getStudentId() {
            return studentId;
        }

        public void setStudentId(Long studentId) {
            this.studentId = studentId;
        }

        public Integer getSemester() {
            return semester;
        }

        public void setSemester(Integer semester) {
            this.semester = semester;
        }

        public String getSubjectCode() {
            return subjectCode;
        }

        public void setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
        }

        // hashCode and equals methods
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IdClass idClass = (IdClass) o;
            return Objects.equals(studentId, idClass.studentId) &&
                   Objects.equals(semester, idClass.semester) &&
                   Objects.equals(subjectCode, idClass.subjectCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, semester, subjectCode);
        }
    }
}
