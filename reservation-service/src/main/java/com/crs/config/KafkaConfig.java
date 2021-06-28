package com.crs.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.crs.reservation.app.dto.HotelResponseDTO;



@Configuration
@EnableKafka
public class KafkaConfig {
	
	@Value("${kafka.boot.server}")
	private String kafkaServer;
	
	@Value("${kafka.consumer.groupid}")
	private String consumerGroupId;
	
	@Bean
	public ConsumerFactory<String, HotelResponseDTO> consumerFactory() {
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaServer);
		config.put(ConsumerConfig.GROUP_ID_CONFIG,consumerGroupId);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(config,null,new JsonDeserializer<HotelResponseDTO>(HotelResponseDTO.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, HotelResponseDTO> listenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, HotelResponseDTO> listenerFactory = new ConcurrentKafkaListenerContainerFactory<String, HotelResponseDTO>();
		listenerFactory.setConsumerFactory(consumerFactory());
		return listenerFactory;
	}

}
