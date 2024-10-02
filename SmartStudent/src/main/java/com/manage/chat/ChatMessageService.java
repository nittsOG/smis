package com.manage.chat;

import com.manage.chat.entities.ChatMessage;
import java.util.List;

public interface ChatMessageService {
    void sendMessage(ChatMessage message);
    List<ChatMessage> getChatHistory(Long studentId, Long facultyId);
    List<ChatMessage> getInbox(Long Id);
}
