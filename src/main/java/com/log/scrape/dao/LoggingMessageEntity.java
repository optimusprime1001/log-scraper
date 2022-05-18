package com.log.scrape.dao;

import javax.persistence.*;

@Entity
@Table(name = "LOGGING_MESSAGE")
public class LoggingMessageEntity{

    @Id
    @GeneratedValue
    private long idInternal;

    @Column(name = "ID", unique = true)
    private String id;

    @Column(name = "STATE")
    private State state;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "HOST")
    private String host;

    @Column(name = "CREATED_TIME")
    private long timestamp;

    @Column(name = "DURATION")
    private long duration;

    @Column(name = "ALERT")
    private boolean alert;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LoggingMessageEntity.State getState() {
        return state;
    }

    public void setState(LoggingMessageEntity.State state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public enum State {STARTED, FINISHED};

    @Override
    public String toString() {
        return "LoggingMessageEntity{" +
                "id='" + id + '\'' +
                ", state=" + state +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", timestamp=" + timestamp +
                ", duration=" + duration +
                ", alert=" + alert +
                '}';
    }
}
