package com.log.scrape.service;

import com.log.scrape.model.LoggingMessage;

import java.util.List;

public interface LogScrapingService {
    public void processLoggingMessage(LoggingMessage loggingMessage);

    public int getProcessedLoggingMessagesCount();

}
