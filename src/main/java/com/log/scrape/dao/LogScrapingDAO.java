package com.log.scrape.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogScrapingDAO extends CrudRepository<LoggingMessageEntity, Long> {
    public LoggingMessageEntity findById(String id);
}
