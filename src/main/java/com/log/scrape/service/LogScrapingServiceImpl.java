package com.log.scrape.service;

import com.log.scrape.dao.LogScrapingDAO;
import com.log.scrape.dao.LoggingMessageEntity;
import com.log.scrape.model.LoggingMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class LogScrapingServiceImpl implements LogScrapingService{

    private static final Logger logger = LoggerFactory.getLogger(LogScrapingServiceImpl.class);

    @Autowired
    private LogScrapingDAO dao;

    @Value("${log.scraper.alert.threshold.millis}")
    private int thresholdMillis;

    private int processedLoggingMessagesCount = 0;

    @Async
    @Override
    public void processLoggingMessage(LoggingMessage incomingMessage) {
        LoggingMessageEntity entity = new LoggingMessageEntity();
        BeanUtils.copyProperties(incomingMessage, entity);
        try {
            dao.save(entity);
            logger.info("Saved logging message {}", entity);
        }catch(DataIntegrityViolationException exception){
            // find the existing DAO
            entity = dao.findById(incomingMessage.getId());
            long timeTaken = Math.abs(entity.getTimestamp() - incomingMessage.getTimestamp());
            entity.setDuration(timeTaken);
            entity.setAlert(timeTaken > thresholdMillis);
            dao.save(entity);
            logger.warn("Found an existing record {} in DB, updating duration {} and alert level as {}",
                    entity.getId(),
                    entity.getDuration(),
                    entity.isAlert());
        }
        processedLoggingMessagesCount++;
    }

    @Override
    public int getProcessedLoggingMessagesCount() {
        return processedLoggingMessagesCount;
    }

    /*public List<LoggingMessage> getAllLoggingMessages() {
        List<LoggingMessage> loggingMessageList = new ArrayList<>();
        Iterator<LoggingMessageEntity> iterator = dao.findAll().iterator();
        while (iterator.hasNext()){
            LoggingMessageEntity loggingEntity = iterator.next();
            LoggingMessage loggingMessage = new LoggingMessage();
            BeanUtils.copyProperties(loggingEntity, loggingMessage);
            loggingMessageList.add(loggingMessage);
        }
        return loggingMessageList;
    }*/


}
