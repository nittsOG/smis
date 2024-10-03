package com.manage.home.entities;

import java.util.Date;
import javax.persistence.*;

import com.manage.faculty.entities.Faculty;
import com.manage.student.entities.Student;

@Entity
@Table(name = "community_post")
public class CommunityPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long postId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "community_id", nullable = false)
	private Community community;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id", nullable = true)
	private Student student; // The student who posted (if applicable)

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "faculty_id", nullable = true)
	private Faculty faculty; // The faculty who posted (if applicable)

	@Column(name = "content", nullable = false, columnDefinition = "TEXT")
	private String content; // Text message content

	@Lob
	@Column(name = "attachment_data")
	private byte[] attachmentData; // Binary data for image or file

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date timestamp;

	@PrePersist
	protected void onCreate() {
		timestamp = new Date(); // Set the current timestamp
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "post_type", nullable = false)
	private PostType postType; // Enum for type (TEXT, IMAGE, LINK)

	@Transient
	private String photoBase64;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getAttachmentData() {
		return attachmentData;
	}

	public void setAttachmentData(byte[] attachmentData) {
		this.attachmentData = attachmentData;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public PostType getPostType() {
		return postType;
	}

	public void setPostType(PostType postType) {
		this.postType = postType;
	}

	public String getPhotoBase64() {
		return photoBase64;
	}

	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}

}
