package org.pathfinder2.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name = "data_time")
    private Instant dataTime;
    @Column(name = "text_content",nullable = false)
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private User recipient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getDataTime() {
        return dataTime;
    }

    public void setDataTime(Instant dataTime) {
        this.dataTime = dataTime;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Message() {
    }
}
