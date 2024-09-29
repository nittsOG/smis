package com.manage.student.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fee")
public class Fee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fee_id")
	private Long feeId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "studentsemester_id" , nullable = false)
	private StudentSemester studentSemester;

	@Column(name = "total_amount")
	private BigDecimal totalAmount;

	@Column(name = "paid_amount")
	private BigDecimal paidAmount;

	@Column(name = "due_date")
	private Date dueDate;


	// Getters and Setters

	public Long getFeeId() {
		return feeId;
	}

	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}


	public StudentSemester getStudentSemester() {
		return studentSemester;
	}

	public void setStudentSemester(StudentSemester studentSemester) {
		this.studentSemester = studentSemester;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date date) {
		this.dueDate = date;
	}

}
