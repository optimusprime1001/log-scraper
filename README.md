# Log Scraper
## Overview
This tool parses log lines in JSON format and asynchronously persists them in DB
- Written in SpringBoot
- Uses Spring Async feature
- Stores data in embedded HSQLDB

## How to build
```sh
mvn clean install
/path/to/java8/bin/java -jar target/jarname.jar /path/to/the/json/log/file
```

## Sample output
```
,--.                             ,---.
|  |     ,---.   ,---.  ,-----. '   .-'   ,---. ,--.--.  ,--,--.  ,---.   ,---.  ,--.--.
|  |    | .-. | | .-. | '-----' `.  `-.  | .--' |  .--' ' ,-.  | | .-. | | .-. : |  .--'
|  '--. ' '-' ' ' '-' '         .-'    | \ `--. |  |    \ '-'  | | '-' ' \   --. |  |
`-----'  `---'  .`-  /          `-----'   `---' `--'     `--`--' |  |-'   `----' `--'
                `---'                                            `--'
 
Powered by Spring Boot 2.6.7
2022-05-18 13:50:45.716  INFO 1350 --- [           main] com.log.scrape.LogScraperApplication     : Starting LogScraperApplication using Java 15.0.1 on Anants-iMac.local with PID 1350 (/Users/anant/dev/log-scraper/target/classes started by anant in /Users/anant/dev/log-scraper)
2022-05-18 13:50:45.718  INFO 1350 --- [           main] com.log.scrape.LogScraperApplication     : No active profile set, falling back to 1 default profile: "default"
2022-05-18 13:50:46.062  INFO 1350 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-05-18 13:50:46.104  INFO 1350 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 33 ms. Found 1 JPA repository interfaces.
2022-05-18 13:50:46.398  INFO 1350 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-05-18 13:50:46.446  INFO 1350 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.6.8.Final
2022-05-18 13:50:46.594  INFO 1350 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2022-05-18 13:50:46.674  INFO 1350 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-05-18 13:50:46.861  INFO 1350 --- [           main] hsqldb.db.HSQLDB80D5545DE7.ENGINE        : checkpointClose start
2022-05-18 13:50:46.861  INFO 1350 --- [           main] hsqldb.db.HSQLDB80D5545DE7.ENGINE        : checkpointClose synched
2022-05-18 13:50:46.867  INFO 1350 --- [           main] hsqldb.db.HSQLDB80D5545DE7.ENGINE        : checkpointClose script done
2022-05-18 13:50:46.869  INFO 1350 --- [           main] hsqldb.db.HSQLDB80D5545DE7.ENGINE        : checkpointClose end
2022-05-18 13:50:46.873  INFO 1350 --- [           main] com.zaxxer.hikari.pool.PoolBase          : HikariPool-1 - Driver does not support get/set network timeout for connections. (feature not supported)
2022-05-18 13:50:46.876  INFO 1350 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-05-18 13:50:46.893  INFO 1350 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.HSQLDialect
2022-05-18 13:50:47.308  INFO 1350 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2022-05-18 13:50:47.314  INFO 1350 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2022-05-18 13:50:47.641  INFO 1350 --- [           main] com.log.scrape.LogScraperApplication     : Started LogScraperApplication in 2.199 seconds (JVM running for 2.846)
2022-05-18 13:50:47.642  INFO 1350 --- [           main] com.log.scrape.parse.LogParser           : Parsing file at /var/tmp/sample.json
2022-05-18 13:50:47.818  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='2cb0e980-5c4c-4506-81ca-cb19bf5fa1a7', state=null, type='APPLICATION_LOG', host='16362', timestamp=1442590804848, duration=0, alert=false}
2022-05-18 13:50:47.818  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='3d7f7f7b-293f-4076-b4e6-a664f0a63344', state=null, type='APPLICATION_LOG', host='17214', timestamp=1447683283250, duration=0, alert=false}
2022-05-18 13:50:47.819  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='c730b9ee-883a-444f-9010-006819ddc998', state=null, type='APPLICATION_LOG', host='19156', timestamp=1689148187826, duration=0, alert=false}
2022-05-18 13:50:47.819  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='6a44545d-cff3-4538-aee2-27d6e5a9c7a6', state=null, type='APPLICATION_LOG', host='12958', timestamp=1739572356244, duration=0, alert=false}
2022-05-18 13:50:47.819  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='6a981575-f948-4e0f-b089-51f13c517f89', state=null, type='APPLICATION_LOG', host='15618', timestamp=2201981136754, duration=0, alert=false}
2022-05-18 13:50:47.819  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='05464f31-7313-438c-bddb-33709d07c5bc', state=null, type='APPLICATION_LOG', host='17459', timestamp=1282473668264, duration=0, alert=false}
2022-05-18 13:50:47.820  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='6def9cf9-c9ed-4c17-89de-339f130115b2', state=null, type='APPLICATION_LOG', host='18105', timestamp=2164032574625, duration=0, alert=false}
2022-05-18 13:50:47.820  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='0359a796-648c-4926-9228-24bc078f2882', state=null, type='APPLICATION_LOG', host='16030', timestamp=1769112632544, duration=0, alert=false}
2022-05-18 13:50:47.820  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='58eeae27-e8dc-4cd7-9344-e4750b03158f', state=null, type='APPLICATION_LOG', host='18704', timestamp=1925622306810, duration=0, alert=false}
2022-05-18 13:50:47.821  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='867d8a31-7dcc-4c21-9c15-a1d3a4b9f0c9', state=null, type='APPLICATION_LOG', host='18443', timestamp=1798344038699, duration=0, alert=false}
2022-05-18 13:50:47.821  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='dcc36401-3c61-4989-92ff-abfb0aa9a85b', state=null, type='APPLICATION_LOG', host='13558', timestamp=1940093297632, duration=0, alert=false}
2022-05-18 13:50:47.821  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='c813c390-21eb-454e-8891-5f903793ae23', state=null, type='APPLICATION_LOG', host='16990', timestamp=1990062027355, duration=0, alert=false}
2022-05-18 13:50:47.822  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='d7ea7c3c-b5ce-4b7b-b2c8-8c549ced09f9', state=null, type='APPLICATION_LOG', host='18742', timestamp=1763165225804, duration=0, alert=false}
2022-05-18 13:50:47.822  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='512acb63-3786-47fe-8f8f-c96af6356db0', state=null, type='APPLICATION_LOG', host='12931', timestamp=1798872167317, duration=0, alert=false}
2022-05-18 13:50:47.823  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='a5e6b41a-a527-45d7-a732-22f8e6fb122e', state=null, type='APPLICATION_LOG', host='14854', timestamp=1602489671123, duration=0, alert=false}
2022-05-18 13:50:47.823  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='a50109fb-ae4a-4dea-9970-26d1b6a0d7cc', state=null, type='APPLICATION_LOG', host='14946', timestamp=1897944606466, duration=0, alert=false}
2022-05-18 13:50:47.824  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='83c189fa-b006-41cf-8647-20f4555d9683', state=null, type='APPLICATION_LOG', host='12000', timestamp=1382872253394, duration=0, alert=false}
2022-05-18 13:50:47.824  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='f850061c-a5d1-4ea4-b26c-73b07af46f5d', state=null, type='APPLICATION_LOG', host='12374', timestamp=1508194885649, duration=0, alert=false}
2022-05-18 13:50:47.824  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='392eb964-0367-41b6-bece-d629bbe025c9', state=null, type='APPLICATION_LOG', host='10602', timestamp=1264407524852, duration=0, alert=false}
2022-05-18 13:50:47.824  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='65e86fd5-6307-4799-8b30-d1ce79f48e40', state=null, type='APPLICATION_LOG', host='17712', timestamp=1790816595714, duration=0, alert=false}
2022-05-18 13:50:47.825  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='9e9797c8-289b-4f79-8da7-5a76cbff5f3b', state=null, type='APPLICATION_LOG', host='17354', timestamp=2048908095109, duration=0, alert=false}
2022-05-18 13:50:47.825  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='e97526f9-11c2-4d43-900d-46c955ce1ce1', state=null, type='APPLICATION_LOG', host='19037', timestamp=1304622993983, duration=0, alert=false}
2022-05-18 13:50:47.825  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='06b27e9d-5d4e-48a6-a805-5ca71ceabba6', state=null, type='APPLICATION_LOG', host='14582', timestamp=1236544273503, duration=0, alert=false}
2022-05-18 13:50:47.826  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='f3208aa7-b0e2-4a08-85b8-0deb0ea3f061', state=null, type='APPLICATION_LOG', host='13260', timestamp=1537459690242, duration=0, alert=false}
2022-05-18 13:50:47.826  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='121537ef-078c-4d91-932d-85068b4c8f5a', state=null, type='APPLICATION_LOG', host='11975', timestamp=1472672623515, duration=0, alert=false}
2022-05-18 13:50:47.826  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='7e316d01-053e-47ba-a2c3-9c934e50e22b', state=null, type='APPLICATION_LOG', host='17192', timestamp=1987682493468, duration=0, alert=false}
2022-05-18 13:50:47.826  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='65b06949-a252-4833-83ae-5ad3d713ab74', state=null, type='APPLICATION_LOG', host='13324', timestamp=1666763354618, duration=0, alert=false}
2022-05-18 13:50:47.827  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='6f30e2fc-6311-40ca-8a31-5dc3fc427ba2', state=null, type='APPLICATION_LOG', host='16704', timestamp=1396937691273, duration=0, alert=false}
2022-05-18 13:50:47.827  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='22cdff2b-7581-4f22-9094-b2a202a71da5', state=null, type='APPLICATION_LOG', host='14603', timestamp=1819074967792, duration=0, alert=false}
2022-05-18 13:50:47.827  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='b63450a4-8ccc-4593-97b1-77d06ca58038', state=null, type='APPLICATION_LOG', host='16225', timestamp=2018740840021, duration=0, alert=false}
2022-05-18 13:50:47.827  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='635c63b3-6dd1-4966-ad82-2c644da1ac36', state=null, type='APPLICATION_LOG', host='19655', timestamp=1930634019243, duration=0, alert=false}
2022-05-18 13:50:47.828  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='4e24b764-b6df-46e1-b121-d6346e4c2105', state=null, type='APPLICATION_LOG', host='18317', timestamp=1979924141979, duration=0, alert=false}
2022-05-18 13:50:47.828  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='2c016e45-b37a-4646-b06c-5add4ca2bbd2', state=null, type='APPLICATION_LOG', host='17663', timestamp=1738569245540, duration=0, alert=false}
2022-05-18 13:50:47.828  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='2e4f6f54-6753-4c14-a434-38879a5cd04a', state=null, type='APPLICATION_LOG', host='12280', timestamp=1867959160673, duration=0, alert=false}
2022-05-18 13:50:47.828  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='cd6c7424-08ea-40f8-8096-c61b21932e23', state=null, type='APPLICATION_LOG', host='15518', timestamp=2189182252835, duration=0, alert=false}
2022-05-18 13:50:47.829  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='a8ecf889-14c4-4ffb-ad31-cb2215d58260', state=null, type='APPLICATION_LOG', host='12383', timestamp=1664856420814, duration=0, alert=false}
2022-05-18 13:50:47.829  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='c41f1b3b-1a0b-488b-a9bd-29fc87d24c3b', state=null, type='APPLICATION_LOG', host='15332', timestamp=2048521639135, duration=0, alert=false}
2022-05-18 13:50:47.829  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='72f09325-3c45-4aad-b3fa-36cf6df4e324', state=null, type='APPLICATION_LOG', host='13729', timestamp=2168428455368, duration=0, alert=false}
2022-05-18 13:50:47.830  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='8aff6317-7384-4938-aa90-5cd8ee212cb3', state=null, type='APPLICATION_LOG', host='14958', timestamp=1477493419368, duration=0, alert=false}
2022-05-18 13:50:47.830  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='edb7fcdc-8cb4-4912-82f1-be59f32fc817', state=null, type='APPLICATION_LOG', host='17354', timestamp=1412542338257, duration=0, alert=false}
2022-05-18 13:50:47.830  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='b39a83f6-bcec-4f9c-876d-563a6b4000b3', state=null, type='APPLICATION_LOG', host='10700', timestamp=1555685250704, duration=0, alert=false}
2022-05-18 13:50:47.830  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='f1f764ba-9e0f-4a7a-b16d-eac91c3115de', state=null, type='APPLICATION_LOG', host='18131', timestamp=2027617125033, duration=0, alert=false}
2022-05-18 13:50:47.831  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='8f7ed430-5bc1-4339-8dd7-537106463e0d', state=null, type='APPLICATION_LOG', host='15424', timestamp=2165386479773, duration=0, alert=false}
2022-05-18 13:50:47.831  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='035df6ee-06f4-422a-8b1b-c5da8a719ec8', state=null, type='APPLICATION_LOG', host='10581', timestamp=2155015959101, duration=0, alert=false}
2022-05-18 13:50:47.831  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='99f5d1ee-6949-4fa3-929a-fdd5be7a838b', state=null, type='APPLICATION_LOG', host='19225', timestamp=1487956280254, duration=0, alert=false}
2022-05-18 13:50:47.831  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='85fea426-01e3-480e-8a39-eb8b45a3e140', state=null, type='APPLICATION_LOG', host='18753', timestamp=2203059349984, duration=0, alert=false}
2022-05-18 13:50:47.832  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='67f9ac19-30b7-4bb4-b02d-5c9dcc0821c3', state=null, type='APPLICATION_LOG', host='11328', timestamp=1990061530870, duration=0, alert=false}
2022-05-18 13:50:47.832  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='370ac646-3e4e-46cd-8e48-c850a24ae53c', state=null, type='APPLICATION_LOG', host='17660', timestamp=1630719805980, duration=0, alert=false}
2022-05-18 13:50:47.832  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='e2cf521d-998a-4218-bc9f-7fd76e4cf516', state=null, type='APPLICATION_LOG', host='12860', timestamp=2104626084791, duration=0, alert=false}
2022-05-18 13:50:47.832  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='ad5a74de-ef0e-4850-a392-d30554c6bb8b', state=null, type='APPLICATION_LOG', host='10274', timestamp=1301670636002, duration=0, alert=false}
2022-05-18 13:50:47.832  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='12a09ba5-8f37-4111-9128-12ab0347ee19', state=null, type='APPLICATION_LOG', host='19867', timestamp=1928981311910, duration=0, alert=false}
2022-05-18 13:50:47.833  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='5b94de0c-39ed-4744-82f0-2cee0e5ff084', state=null, type='APPLICATION_LOG', host='14846', timestamp=2037544934388, duration=0, alert=false}
2022-05-18 13:50:47.833  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='5266513a-bb17-4b57-ad2f-05a040a8cebb', state=null, type='APPLICATION_LOG', host='18953', timestamp=2218846250294, duration=0, alert=false}
2022-05-18 13:50:47.833  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='fc031e18-bb50-4d52-9b96-40aebdc0227e', state=null, type='APPLICATION_LOG', host='17257', timestamp=1513644345034, duration=0, alert=false}
2022-05-18 13:50:47.834  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='5f60b2e0-5244-44ec-86a8-fa079dd64ff7', state=null, type='APPLICATION_LOG', host='18456', timestamp=1620720709404, duration=0, alert=false}
2022-05-18 13:50:47.834  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='be6ec6e0-500d-41e9-b898-662fdc2d0ba7', state=null, type='APPLICATION_LOG', host='14820', timestamp=2059992462155, duration=0, alert=false}
2022-05-18 13:50:47.834  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='3e8b6e1f-7a4e-432a-9007-4bfe643657d6', state=null, type='APPLICATION_LOG', host='17357', timestamp=1915372646208, duration=0, alert=false}
2022-05-18 13:50:47.834  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='12efb7a3-6460-4f07-af02-533943e1f599', state=null, type='APPLICATION_LOG', host='13383', timestamp=1647057313584, duration=0, alert=false}
2022-05-18 13:50:47.835  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='5413248e-2feb-441b-a7eb-dd2ae6ac1f65', state=null, type='APPLICATION_LOG', host='14972', timestamp=1963920268790, duration=0, alert=false}
2022-05-18 13:50:47.835  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='a74d5104-9553-4cc7-8c79-b154f337d5f3', state=null, type='APPLICATION_LOG', host='18825', timestamp=1931232066743, duration=0, alert=false}
2022-05-18 13:50:47.835  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='7416b4ea-8761-4356-b6f6-c4f4e72ee8ff', state=null, type='APPLICATION_LOG', host='18997', timestamp=1393977614290, duration=0, alert=false}
2022-05-18 13:50:47.835  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='d8455594-a377-463c-b725-b1abc80dd59e', state=null, type='APPLICATION_LOG', host='11143', timestamp=1710249495396, duration=0, alert=false}
2022-05-18 13:50:47.836  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='304be209-41ec-4425-a0b7-e8f2fb739c31', state=null, type='APPLICATION_LOG', host='11679', timestamp=1387612759250, duration=0, alert=false}
2022-05-18 13:50:47.836  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='ca675413-5d86-4cc4-9b8a-80bfec5afba9', state=null, type='APPLICATION_LOG', host='19234', timestamp=1521499047925, duration=0, alert=false}
2022-05-18 13:50:47.836  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='2fb77e79-1203-49ca-a68b-5b14af3ef3a7', state=null, type='APPLICATION_LOG', host='15979', timestamp=2100579749527, duration=0, alert=false}
2022-05-18 13:50:47.837  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='ae36c371-5d45-40e9-933e-44a76abe04e1', state=null, type='APPLICATION_LOG', host='17959', timestamp=2175206818006, duration=0, alert=false}
2022-05-18 13:50:47.837  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='b8613b06-5330-4e90-ae99-2ef24e09e492', state=null, type='APPLICATION_LOG', host='11124', timestamp=1824454800247, duration=0, alert=false}
2022-05-18 13:50:47.837  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='7ff551c4-e623-40d1-b1b8-d127cb8d0c4e', state=null, type='APPLICATION_LOG', host='10980', timestamp=1916724375728, duration=0, alert=false}
2022-05-18 13:50:47.837  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='3b761896-8ea9-4df2-b8ba-5e947014c894', state=null, type='APPLICATION_LOG', host='13140', timestamp=1460317032340, duration=0, alert=false}
2022-05-18 13:50:47.838  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='49ac05c1-95ff-4e67-81e0-07b048d096cc', state=null, type='APPLICATION_LOG', host='14286', timestamp=1731958279854, duration=0, alert=false}
2022-05-18 13:50:47.838  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='b0b4e063-7d0c-4848-b839-e35df1b71d85', state=null, type='APPLICATION_LOG', host='11074', timestamp=2059414318891, duration=0, alert=false}
2022-05-18 13:50:47.838  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='33733786-e8a5-4bed-bfa5-613c1db315cf', state=null, type='APPLICATION_LOG', host='11693', timestamp=1469339066377, duration=0, alert=false}
2022-05-18 13:50:47.838  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='0d5b6b1b-c5dc-40b3-94b5-79f292ef17a7', state=null, type='APPLICATION_LOG', host='18360', timestamp=1402015119832, duration=0, alert=false}
2022-05-18 13:50:47.839  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='5a9f9e10-733a-4729-a6f9-7c9f350e754a', state=null, type='APPLICATION_LOG', host='14396', timestamp=1511670478004, duration=0, alert=false}
2022-05-18 13:50:47.839  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='5c689ff4-976c-48de-bc1c-3b63eb53b7cb', state=null, type='APPLICATION_LOG', host='15182', timestamp=1885477339801, duration=0, alert=false}
2022-05-18 13:50:47.840  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='fe389200-730b-4ece-9912-94ab7f8a2595', state=null, type='APPLICATION_LOG', host='19103', timestamp=2109022277561, duration=0, alert=false}
2022-05-18 13:50:47.840  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='aceb27fe-37a5-42b5-a461-8b7f244d0cde', state=null, type='APPLICATION_LOG', host='11959', timestamp=1307855096001, duration=0, alert=false}
2022-05-18 13:50:47.840  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='a9bb8929-f2b0-4e5b-ac7a-511582308caf', state=null, type='APPLICATION_LOG', host='19579', timestamp=1499097069786, duration=0, alert=false}
2022-05-18 13:50:47.840  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='189bb0d7-587a-4984-ad63-6c0b45a9e125', state=null, type='APPLICATION_LOG', host='16203', timestamp=1862012459044, duration=0, alert=false}
2022-05-18 13:50:47.841  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='eddd0155-9c90-45e4-9606-db1c05b9ecda', state=null, type='APPLICATION_LOG', host='13719', timestamp=1812340793138, duration=0, alert=false}
2022-05-18 13:50:47.842  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='71b2ef0c-c96a-4cf2-a9a1-6d119e9ee882', state=null, type='APPLICATION_LOG', host='17453', timestamp=1491894803314, duration=0, alert=false}
2022-05-18 13:50:47.842  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='da19b702-d107-46b3-9f9d-375fb688048a', state=null, type='APPLICATION_LOG', host='16253', timestamp=2146670370938, duration=0, alert=false}
2022-05-18 13:50:47.842  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='9deee643-85f7-43dd-9894-d0814b0c4166', state=null, type='APPLICATION_LOG', host='14046', timestamp=2161647144291, duration=0, alert=false}
2022-05-18 13:50:47.842  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='66cb32fe-bf91-4959-a2a0-cce163a446f2', state=null, type='APPLICATION_LOG', host='13367', timestamp=2188943902506, duration=0, alert=false}
2022-05-18 13:50:47.843  INFO 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='33e9ee27-d786-4a43-9dc6-3de9d110287c', state=null, type='APPLICATION_LOG', host='11204', timestamp=2156283330785, duration=0, alert=false}
2022-05-18 13:50:47.843  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='e8eac036-855e-44a1-b2cd-a3a3978aba2d', state=null, type='APPLICATION_LOG', host='16595', timestamp=1909003264199, duration=0, alert=false}
2022-05-18 13:50:47.843  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='ae672287-01e5-4dc1-8a65-5cb06eb6d593', state=null, type='APPLICATION_LOG', host='14087', timestamp=1808400128952, duration=0, alert=false}
2022-05-18 13:50:47.843  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='a10325d2-1127-4e78-9085-94c8fd6e89a5', state=null, type='APPLICATION_LOG', host='12588', timestamp=1596129236408, duration=0, alert=false}
2022-05-18 13:50:47.843  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='83b2b1ca-abc3-425a-a8fa-5addd0c0f689', state=null, type='APPLICATION_LOG', host='11150', timestamp=1767601435331, duration=0, alert=false}
2022-05-18 13:50:47.844  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='c816c9e0-3bce-4961-83ef-500af92d9af0', state=null, type='APPLICATION_LOG', host='19569', timestamp=1790212720045, duration=0, alert=false}
2022-05-18 13:50:47.844  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='093c7a4f-e48b-407f-9224-7839f2d4ae43', state=null, type='APPLICATION_LOG', host='12811', timestamp=1760701131493, duration=0, alert=false}
2022-05-18 13:50:47.844  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='19edb07b-e5f2-44fd-9519-ded106157af7', state=null, type='APPLICATION_LOG', host='11872', timestamp=1867079390446, duration=0, alert=false}
2022-05-18 13:50:47.845  WARN 1350 --- [         task-4] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Error: -104, SQLState: 23505
2022-05-18 13:50:47.845 ERROR 1350 --- [         task-4] o.h.engine.jdbc.spi.SqlExceptionHelper   : integrity constraint violation: unique constraint or index violation; UK_9HFTEWO5JL63KNP0BRMVFU9KA table: LOGGING_MESSAGE
2022-05-18 13:50:47.846  INFO 1350 --- [         task-4] o.h.e.j.b.internal.AbstractBatchImpl     : HHH000010: On release of batch it still contained JDBC statements
2022-05-18 13:50:47.850  INFO 1350 --- [         task-8] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='d25686fc-7d48-4730-be2d-79a6e7beec4c', state=null, type='APPLICATION_LOG', host='18373', timestamp=1913729870684, duration=0, alert=false}
2022-05-18 13:50:47.850  INFO 1350 --- [         task-2] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='f2730bf1-dd89-4432-bb73-fe3045e82557', state=null, type='APPLICATION_LOG', host='12231', timestamp=1582485768231, duration=0, alert=false}
2022-05-18 13:50:47.850  INFO 1350 --- [         task-7] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='c73c5df6-a238-43db-a8d7-8f9d5fe2ee48', state=null, type='APPLICATION_LOG', host='19959', timestamp=1417089385563, duration=0, alert=false}
2022-05-18 13:50:47.850  INFO 1350 --- [         task-5] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='a233d2b4-1d19-436e-9b63-3520eb84cbfd', state=null, type='APPLICATION_LOG', host='19537', timestamp=1857253441335, duration=0, alert=false}
2022-05-18 13:50:47.850  INFO 1350 --- [         task-3] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='33c47e7b-c380-4079-a20b-a5ec87987d65', state=null, type='APPLICATION_LOG', host='14228', timestamp=2206121142132, duration=0, alert=false}
2022-05-18 13:50:47.850  INFO 1350 --- [         task-6] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='b77e3b16-322a-436b-b035-39f45552ce13', state=null, type='APPLICATION_LOG', host='18151', timestamp=2060300557815, duration=0, alert=false}
2022-05-18 13:50:47.850  INFO 1350 --- [         task-1] c.l.s.service.LogScrapingServiceImpl     : Saved logging message LoggingMessageEntity{id='f50d12b3-28e3-4ab2-8422-31ee70f0636c', state=null, type='APPLICATION_LOG', host='16452', timestamp=1715347827538, duration=0, alert=false}
2022-05-18 13:50:47.953  WARN 1350 --- [         task-4] c.l.s.service.LogScrapingServiceImpl     : Found an existing record d7ea7c3c-b5ce-4b7b-b2c8-8c549ced09f9 in DB, updating duration 163116615703 and alert level as true
2022-05-18 13:50:48.350  INFO 1350 --- [           main] com.log.scrape.LogScraperApplication     : Processing complete in 708, exiting. Count of processed records is 100
2022-05-18 13:50:48.352  INFO 1350 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2022-05-18 13:50:48.360  INFO 1350 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-05-18 13:50:48.362  INFO 1350 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

```