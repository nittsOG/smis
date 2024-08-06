package com.manage.student.entities;

import javax.persistence.*;
import com.manage.home.entities.Division;

import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "student_id")
	    private Long studentId;

	    @Column(name = "username", nullable = false, unique = true)
	    private String username;

	    @Column(name = "password", nullable = false)
	    private String password;

	    @Column(name = "email", nullable = false, unique = true)
	    private String email;

	    @Lob
	    @Column(name = "photo")
	    private byte[] photo;

	    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
	    private StudentAddress address;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "division_id")
	    private Division division;

	    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	    private Set<Fee> fees;

	    @Transient
	    private String photoBase64;

    // Getters and Setters

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public StudentAddress getAddress() {
        return address;
    }

    public void setAddress(StudentAddress address) {
        this.address = address;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Set<Fee> getFees() {
        return fees;
    }

    public void setFees(Set<Fee> fees) {
        this.fees = fees;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", username=" + username + ", password=" + password + ", email="
				+ email + ", photo=" + Arrays.toString(photo) + ", address=" + address + ", division=" + division
				+ ", fees=" + fees + "]";
	}
    
    
}
