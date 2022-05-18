package com.log.scrape.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

@Configuration
@EnableAsync
public class LogScraperApplicationConfig {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Configuration
    public class AsynchronousSpringEventsConfig {
        @Bean(name = "applicationEventMulticaster")
        public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
            SimpleApplicationEventMulticaster eventMulticaster =
                    new SimpleApplicationEventMulticaster();
            eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
            return eventMulticaster;
        }
    }

    /*@Bean
    public DataSource getDataSource(@Value("${spring.datasource.driver-class-name}") String driverClass,
                                    @Value("${spring.datasource.url}") String datasourceURL,
                                    @Value("${spring.datasource.username}") String username,
                                    @Value("${spring.datasource.password}") String password){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClass);
        dataSourceBuilder.url(datasourceURL);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        DataSource ds = dataSourceBuilder.build();
        return ds;
    }*/

    /*@Bean(initMethod = "start", destroyMethod = "stop")
    public org.hsqldb.Server hsqldbServer(@Value("${hsqldb.server.path}") String path,
                                   @Value("${hsqldb.port}") int port,
                                   @Value("${hsqldb.name}") String name) {

        org.hsqldb.Server server = new org.hsqldb.Server();
        server.setDatabaseName(0, name);
        server.setDatabasePath(0, path);
        server.setPort(port);
        server.setLogWriter(slf4jPrintWriter());
        server.setErrWriter(slf4jPrintWriter());
        return server;
    }

    private PrintWriter slf4jPrintWriter() {
        PrintWriter printWriter = new PrintWriter(new ByteArrayOutputStream()) {
            @Override
            public void println(final String x) {
                log.debug(x);
            }
        };
        return printWriter;
    }*/
}
