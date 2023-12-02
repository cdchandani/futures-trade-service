package com.chanchal.futurestradeservice.dao;

import com.chanchal.futurestradeservice.bo.FuturesTradesBO;
import com.chanchal.futurestradeservice.processor.impl.FuturesTradeProcessor;
import com.chanchal.futurestradeservice.repository.FuturesTradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TradeDao {
    private final Logger logger = LoggerFactory.getLogger(TradeDao.class);

    @Autowired
    private FuturesTradeProcessor transformer;
    @Autowired
    private FuturesTradeRepository repository;

    @CacheEvict(cacheNames = "futuresTrades", key = "#futuresTradesBO.id")
    public FuturesTradesBO persistData(FuturesTradesBO futuresTradesBO) {
        FuturesTradesBO savedFutureTrade = repository.save(futuresTradesBO);
        logger.info("savedFutureTrade::{}", savedFutureTrade);
        return savedFutureTrade;
    }

    @Cacheable(cacheNames = "futuresTrades", key = "id")
    public Optional<FuturesTradesBO> getData(Long id) {
        logger.info("fetching futures trade from db");
        return repository.findById(id);
    }
}
