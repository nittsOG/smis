package com.manage.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.manage.chat.entities.ChatMessage;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) {
        // For one-to-one, send to recipient's queue
        String recipient = chatMessage.getRecipient();
        if (recipient != null && !recipient.isEmpty()) {
            messagingTemplate.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
        } else {
            // If no recipient, broadcast to public topic
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}
