package com.chanchal.futurestradeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FuturesTradeServiceApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(FuturesTradeServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FuturesTradeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Futures Trade Service started");
    }

}
