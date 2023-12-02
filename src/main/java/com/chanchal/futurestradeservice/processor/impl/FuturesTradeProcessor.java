package com.chanchal.futurestradeservice.processor.impl;

import com.chanchal.futurestradeservice.bo.ClientBO;
import com.chanchal.futurestradeservice.bo.FuturesTradesBO;
import com.chanchal.futurestradeservice.processor.IMessageProcessor;
import com.chanchal.futurestradeservice.processor.helper.SimpleMapper;
import com.chanchal.futurestradeservice.to.FuturesTradesTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class FuturesTradeProcessor implements IMessageProcessor<FuturesTradesBO, FuturesTradesTO> {
    private final Logger logger = LoggerFactory.getLogger(FuturesTradeProcessor.class);
    @Autowired
    private RestTemplate restTemplate;
    @Value("${staticdata.service.url}")
    private String staticServiceUrl;

    @Override
    public FuturesTradesBO processMessage(FuturesTradesTO FuturesTradesTO) {
        SimpleMapper instance = SimpleMapper.INSTANCE;
        FuturesTradesBO futuresTradesBO = instance.FuturesTradesTOToFuturesTradesBO(FuturesTradesTO);
        URI uri = UriComponentsBuilder.fromUriString(staticServiceUrl).path("/client")
                .queryParam("code", "mac").build().encode().toUri();
        long start = System.currentTimeMillis();
        ClientBO client = restTemplate.getForObject(uri, ClientBO.class);
        long end = System.currentTimeMillis();
        logger.info("static data received in {} ms", end-start);
        if (client != null) {
            futuresTradesBO.setBrokerClient(client.getName());
        }
        return futuresTradesBO;
    }
}





