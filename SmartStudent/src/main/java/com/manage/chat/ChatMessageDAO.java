package com.manage.chat;

import java.util.List;

import com.manage.chat.entities.ChatMessage;

public interface ChatMessageDAO {

	List<ChatMessage> getInbox(Long Id);

	List<ChatMessage> getChatHistory(Long studentId, Long facultyId);

	void saveMessage(ChatMessage message);

}
