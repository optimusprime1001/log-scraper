package com.log.scrape.model;

import org.springframework.context.ApplicationEvent;

public class LoggingEvent extends ApplicationEvent {
    private LoggingMessage message;

    public LoggingEvent(Object source, LoggingMessage message){
        super(source);
        this.message = message;
    }

    public LoggingMessage getLoggingMessage(){
        return message;
    }
}
