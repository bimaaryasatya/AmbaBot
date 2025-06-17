/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aiassist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatSession {
    private String id;
    private String title;
    private List<ChatMessage> messages;
    private List<Integer> contextTokens;

    public ChatSession() {
        this.id = java.util.UUID.randomUUID().toString();
        this.title = "New Chat";
        this.messages = new ArrayList<>();
        this.contextTokens = new ArrayList<>();
    }

    public ChatSession(String title) {
        this();
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public List<Integer> getContextTokens() {
        return contextTokens;
    }

    public void setContextTokens(List<Integer> contextTokens) {
        this.contextTokens = contextTokens;
    }

    public void addMessage(ChatMessage message) {
        this.messages.add(message);
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatSession that = (ChatSession) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}