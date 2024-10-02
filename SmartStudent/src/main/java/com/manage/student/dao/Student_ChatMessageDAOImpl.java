package com.manage.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.chat.ChatMessageDAO;
import com.manage.chat.entities.ChatMessage;

@Repository
@Qualifier("studentChatMessageDAOImpl")
@Transactional("studentTransactionManager")
public class Student_ChatMessageDAOImpl implements ChatMessageDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public Student_ChatMessageDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveMessage(ChatMessage message) {
		Session session = sessionFactory.getCurrentSession();
		session.save(message);
	}

	@Override
	public List<ChatMessage> getChatHistory(Long studentId, Long facultyId) {
		Session session = sessionFactory.getCurrentSession();
		return session
				.createQuery(
						"FROM ChatMessage WHERE student.id = :studentId AND faculty.id = :facultyId ORDER BY timestamp",
						ChatMessage.class)
				.setParameter("studentId", studentId).setParameter("facultyId", facultyId).getResultList();
	}

	@Override
	public List<ChatMessage> getInbox(Long studentId) {
	    Session session = sessionFactory.getCurrentSession();

	    // Query to get the latest message from each distinct faculty for the student
	    return session.createQuery(
	            "FROM ChatMessage c1 WHERE c1.timestamp = (SELECT MAX(c2.timestamp) " +
	            "FROM ChatMessage c2 WHERE c2.faculty.id = c1.faculty.id AND c2.student.id = :studentId) " +
	            "AND c1.student.id = :studentId ORDER BY c1.timestamp DESC", 
	            ChatMessage.class)
	        .setParameter("studentId", studentId)
	        .getResultList();
	}


}
