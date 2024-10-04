package com.manage.chat.entities;

public class User {
    private Long id;
    private String username; // Add this field
    private SenderType senderType;

    public User(Long id, String username, SenderType senderType) {
        this.id = id;
        this.username = username;
        this.senderType = senderType;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public SenderType getSenderType() {
        return senderType;
    }
}
