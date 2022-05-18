package com.log.scrape.listener;

import com.log.scrape.model.LoggingEvent;
import com.log.scrape.service.LogScrapingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LoggingEventListener {
    private static final Logger logger = LoggerFactory.getLogger(LoggingEventListener.class);
    @Autowired
    private LogScrapingService logScrapingService;

    @Async
    @EventListener
    public void onApplicationEvent(LoggingEvent event) {
        logger.debug("Received logging event {}", event.getLoggingMessage());
        logScrapingService.processLoggingMessage(event.getLoggingMessage());
    }
}
