//package com.manage.chat.entities;
//
//import java.util.Date;
//import javax.persistence.*;
//
//import com.manage.student.entities.Student;
//import com.manage.faculty.entities.Faculty;
//
//@Entity
//@Table(name = "chat_message")
//public class ChatMessage {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "message_id")
//    private Long messageId;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "student_id", nullable = false)
//    private Student student;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "faculty_id", nullable = false)
//    private Faculty faculty;
//
//    @Column(name = "message", nullable = false)
//    private String message;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "sender_type", nullable = false)
//    private SenderType senderType; // Enum to indicate whether the sender is a STUDENT or FACULTY
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "timestamp", nullable = false)
//    private Date timestamp;
//
//    // Constructors
//    public ChatMessage() {
//        this.timestamp = new Date(); // Automatically set the timestamp to current date/time
//    }
//
//    public ChatMessage(Student student, Faculty faculty, String message, SenderType senderType) {
//        this.student = student;
//        this.faculty = faculty;
//        this.message = message;
//        this.senderType = senderType;
//        this.timestamp = new Date(); // Automatically set the timestamp to current date/time
//    }
//
//    // Getters and Setters
//
//    public Long getMessageId() {
//        return messageId;
//    }
//
//    public void setMessageId(Long messageId) {
//        this.messageId = messageId;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public Faculty getFaculty() {
//        return faculty;
//    }
//
//    public void setFaculty(Faculty faculty) {
//        this.faculty = faculty;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public SenderType getSenderType() {
//        return senderType;
//    }
//
//    public void setSenderType(SenderType senderType) {
//        this.senderType = senderType;
//    }
//
//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }
//}

package com.manage.chat.entities;

import java.util.Date;

public class ChatMessage {
    private String sender;
    private String recipient;
    private String message;
    private SenderType senderType;
    private Date timestamp;

    // Constructors
    public ChatMessage() {
        this.timestamp = new Date();
    }

    public ChatMessage(String sender, String recipient, String message, SenderType senderType) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.senderType = senderType;
        this.timestamp = new Date();
    }

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SenderType getSenderType() {
		return senderType;
	}

	public void setSenderType(SenderType senderType) {
		this.senderType = senderType;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

    // Getters and Setters
    // ...
    
}

