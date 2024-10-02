package com.manage.faculty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.chat.ChatMessageDAO;
import com.manage.chat.ChatMessageService;
import com.manage.chat.entities.ChatMessage;

@Service
@Qualifier("facultyChatMessageServiceImpl")
public class Faculty_ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageDAO chatMessageDAO;

    @Autowired
    public Faculty_ChatMessageServiceImpl(@Qualifier("facultyChatMessageDAOImpl") ChatMessageDAO chatMessageDAO) {
        this.chatMessageDAO = chatMessageDAO;
    }

    @Override
   @Transactional(transactionManager = "facultyTransactionManager")
    public void sendMessage(ChatMessage message) {
        chatMessageDAO.saveMessage(message);
    }

    @Override
   @Transactional(transactionManager = "facultyTransactionManager")
    public List<ChatMessage> getChatHistory(Long studentId, Long facultyId) {
        return chatMessageDAO.getChatHistory(studentId, facultyId);
    }

   @Transactional(transactionManager = "facultyTransactionManager")
    public List<ChatMessage> getInbox(Long facultyId) {
        return chatMessageDAO.getInbox(facultyId);
    }
}
