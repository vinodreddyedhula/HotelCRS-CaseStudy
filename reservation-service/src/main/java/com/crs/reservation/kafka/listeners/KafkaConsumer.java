package com.crs.reservation.kafka.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.crs.reservation.app.dto.HotelResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {
	
	
	@KafkaListener(topics="${kafka.topic.name}",groupId="${kafka.consumer.groupid}")
	public void consumer(HotelResponseDTO  message) {		
		log.info("message is :" +message.getKey());	
	}

}
