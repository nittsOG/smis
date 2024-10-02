package com.manage.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.chat.ChatMessageDAO;
import com.manage.chat.ChatMessageService;
import com.manage.chat.entities.ChatMessage;

@Service
@Qualifier("studentChatMessageServiceImpl")
public class Student_ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageDAO chatMessageDAO;

    @Autowired
    public Student_ChatMessageServiceImpl(@Qualifier("studentChatMessageDAOImpl") ChatMessageDAO chatMessageDAO) {
        this.chatMessageDAO = chatMessageDAO;
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public void sendMessage(ChatMessage message) {
        chatMessageDAO.saveMessage(message);
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public List<ChatMessage> getChatHistory(Long studentId, Long facultyId) {
        return chatMessageDAO.getChatHistory(studentId, facultyId);
    }

    @Override
    @Transactional(transactionManager = "studentTransactionManager")
    public List<ChatMessage> getInbox(Long studentId) {
        return chatMessageDAO.getInbox(studentId);
    }
}
