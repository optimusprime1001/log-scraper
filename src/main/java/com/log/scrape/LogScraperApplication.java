package com.log.scrape;

import com.log.scrape.parse.LogParser;
import com.log.scrape.service.LogScrapingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class})*/
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class})
public class LogScraperApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(LogScraperApplication.class);

    @Autowired
    private LogParser logParser;

    @Autowired
    private LogScrapingService logScrapingService;

    public static void main(String[] args) {
        SpringApplication.run(LogScraperApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0){
            logger.error("No input file path provided, exiting!");
            System.exit(1);
        }else {
            try {
                long startTime = System.currentTimeMillis();
                int loggingMessagesCount = logParser.parseFile(args[0]);
                while (logScrapingService.getProcessedLoggingMessagesCount() < loggingMessagesCount) {
                    Thread.sleep(500);
                }
                long processingTime = System.currentTimeMillis() - startTime;
                logger.info("Processing complete in {}, exiting. Count of processed records is {}",
                        processingTime,
                        logScrapingService.getProcessedLoggingMessagesCount());
            }catch (Throwable t){
                logger.error("Exception while running the utility", t);
            }finally {
                System.exit(0);
            }
        }
    }
}
