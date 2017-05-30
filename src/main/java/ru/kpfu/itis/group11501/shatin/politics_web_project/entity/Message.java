package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * @author Oleg Shatin
 *         11-501
 */
@Entity
@Table(name = "Messages")
public class Message implements Comparable{
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User recipient;
    @Column
    private String message_text;
    @Column
    private OffsetDateTime sendingTime;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public OffsetDateTime getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(OffsetDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    public Message(){};
    public Message(int id, String message_text, OffsetDateTime sendingTime) {
        this(message_text,sendingTime);
        this.id = id;

    }

    public Message(String message_text, OffsetDateTime sendingTime) {


        this.message_text = message_text;
        this.sendingTime = sendingTime;
    }

    @Override
    public int compareTo(Object o) {
        return -this.getSendingTime().compareTo(((Message)o).getSendingTime());
    }
}
