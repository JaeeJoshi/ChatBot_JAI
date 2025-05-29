package com.example.JAI3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String Content;
    private String role; //"User" or "BOT"

    @ManyToOne
    @JoinColumn(name="chat_id")
    private Chat chat;

    public Message() {
    }

    public Message(Long id, String content, String role, Chat chat) {
        this.id = id;
        Content = content;
        this.role = role;
        this.chat = chat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    
    
}
