/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aiassist;

public class ChatMessage {
    public enum Sender { USER, AI }

    private Sender sender;
    private String content;

    public ChatMessage(Sender sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public Sender getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}