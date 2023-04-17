package com.redacted.semoresellapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
/*
 * This class implements the Message entity with the attributes:
 * messageID, subject, and content
 * as well as the appropriate getters and setters
 */
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;

    private String subject;
    private String content;

    public Message() {}

    public Message(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public Long getMessageID() {
        return messageID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
