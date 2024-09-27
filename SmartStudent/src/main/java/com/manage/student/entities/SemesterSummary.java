package com.manage.student.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "SemesterSummary")
@IdClass(SemesterSummary.IdClass.class)
public class SemesterSummary {

    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Id
    @Column(name = "semester")
    private Integer semester;

    @Column(name = "total_credits", precision = 5, scale = 2)
    private BigDecimal totalCredits;

    @Column(name = "total_credit_points", precision = 7, scale = 2)
    private BigDecimal totalCreditPoints;

    @Column(name = "sgpa", precision = 3, scale = 2)
    private BigDecimal sgpa;

    @Column(name = "cgpa", precision = 3, scale = 2)
    private BigDecimal cgpa;

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

    public BigDecimal getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(BigDecimal totalCredits) {
        this.totalCredits = totalCredits;
    }

    public BigDecimal getTotalCreditPoints() {
        return totalCreditPoints;
    }

    public void setTotalCreditPoints(BigDecimal totalCreditPoints) {
        this.totalCreditPoints = totalCreditPoints;
    }

    public BigDecimal getSgpa() {
        return sgpa;
    }

    public void setSgpa(BigDecimal sgpa) {
        this.sgpa = sgpa;
    }

    public BigDecimal getCgpa() {
        return cgpa;
    }

    public void setCgpa(BigDecimal cgpa) {
        this.cgpa = cgpa;
    }

    @Embeddable
    public static class IdClass implements Serializable {
        private Long studentId;
        private Integer semester;

        // Default constructor
        public IdClass() {}

        // Parameterized constructor
        public IdClass(Long studentId, Integer semester) {
            this.studentId = studentId;
            this.semester = semester;
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

        // hashCode and equals methods
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IdClass idClass = (IdClass) o;
            return Objects.equals(studentId, idClass.studentId) &&
                   Objects.equals(semester, idClass.semester);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, semester);
        }
    }
}
