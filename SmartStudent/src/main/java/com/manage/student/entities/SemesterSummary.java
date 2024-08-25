package com.manage.student.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "SemesterSummary")
public class SemesterSummary {

	 @Embeddable
	    public static class IdClass implements Serializable {
	        private Integer studentId;
	        private Integer semester;

	        // Default constructor
	        public IdClass() {
	        }

	        // Parameterized constructor
	        public IdClass(Integer studentId, Integer semester) {
	            this.studentId = studentId;
	            this.semester = semester;
	        }

	        // Getters and Setters
	        public Integer getStudentId() {
	            return studentId;
	        }

	        public void setStudentId(Integer studentId) {
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

	    @EmbeddedId
	    private IdClass id;

	    @Column(name = "total_credits")
	    private BigDecimal totalCredits;

	    @Column(name = "total_credit_points")
	    private BigDecimal totalCreditPoints;

	    @Column(name = "sgpa")
	    private BigDecimal sgpa;

	    @Column(name = "cgpa")
	    private BigDecimal cgpa;

    // Getters and Setters
    public IdClass getId() {
        return id;
    }

    public void setId(IdClass id) {
        this.id = id;
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
}
