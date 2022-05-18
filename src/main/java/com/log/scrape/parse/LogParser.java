package com.log.scrape.parse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.log.scrape.model.LoggingEvent;
import com.log.scrape.model.LoggingMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class LogParser {
    private static final Logger logger = LoggerFactory.getLogger(LogParser.class);
    @Autowired
    private ApplicationEventPublisher publisher;

    public int parseFile(String path) throws Exception{
        logger.info("Parsing file at {}", path);
        BufferedReader reader = null;
        String lineRead = "";
        int count = 0;
        try {
            reader = Files.newBufferedReader(Paths.get(new File(path).toURI()));
            while ((lineRead = reader.readLine()) != null) {
                try {
                    processLog(lineRead);
                    count++;
                }catch(IllegalArgumentException e){
                    logger.warn("Exception while processing line [{}]", lineRead);
                }
            }
        }finally{
            if (reader != null){
                reader.close();
            }
        }
        return count;
    }

    private void processLog(String line){
        ObjectMapper mapper = new ObjectMapper();
        try {
            LoggingMessage loggingMessage = mapper.readValue(line, LoggingMessage.class);
            publisher.publishEvent(new LoggingEvent(this, loggingMessage));
            logger.debug("Parsed line [{}]", line);
        }catch(Exception exception){
            throw new IllegalArgumentException();
        }
    }
}
