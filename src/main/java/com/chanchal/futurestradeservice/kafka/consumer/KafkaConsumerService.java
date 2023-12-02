package com.chanchal.futurestradeservice.kafka.consumer;

import com.chanchal.futurestradeservice.bo.ApplicationErrorBO;
import com.chanchal.futurestradeservice.bo.FuturesTradesBO;
import com.chanchal.futurestradeservice.dao.TradeDao;
import com.chanchal.futurestradeservice.processor.impl.FuturesTradeProcessor;
import com.chanchal.futurestradeservice.repository.ApplicationErrorRepository;
import com.chanchal.futurestradeservice.to.FuturesTradesTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class KafkaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Autowired
    private TradeDao tradeDao;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ApplicationErrorRepository errorRepository;

    @Autowired
    private FuturesTradeProcessor transformer;

    @KafkaListener(topics = "future-trades-topic", groupId = "group-1")
    public void receiveMessageFromFirstExchange(String message, @Header(KafkaHeaders.OFFSET) Long offset, @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        logger.info("received message with offset:{} and key: {}. Message:: {}", offset, key, message);
        try {
            FuturesTradesTO futuresTradesTO = objectMapper.readValue(message, FuturesTradesTO.class);
            FuturesTradesBO futuresTradesBO = transformer.processMessage(futuresTradesTO);
            FuturesTradesBO savedFuturesTradeBO = tradeDao.persistData(futuresTradesBO);
            logger.info("transformed and persisted futures trade message for reporting");
        } catch (Exception e) {
            logger.error("Exception occurred while consuming message from future-trades-topic. Key:{}, message:{}", key, message);
            ApplicationErrorBO applicationErrorBO = ApplicationErrorBO.builder().messageType(key).source("First-Exchange").message(message).error(Arrays.toString(e.getStackTrace())).build();
            errorRepository.save(applicationErrorBO);
        }
    }
}
