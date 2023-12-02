package com.chanchal.futurestradeservice.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTempate;

	public void sendMessageToExchange(String message, String topic, String key) {
		kafkaTempate.send(topic, key, message);
	}

}
