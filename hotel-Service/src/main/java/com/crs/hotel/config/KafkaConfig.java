package com.crs.hotel.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.crs.app.hotel.dto.HotelResponseDTO;

@Configuration
@EnableKafka
public class KafkaConfig {
	
	@Value("${kafka.boot.server}")
	private String kafkaServer;
	
	
	@Bean
	public KafkaTemplate<String,HotelResponseDTO> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, HotelResponseDTO> producerFactory() {
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}

	

	/*
	 * @Bean public ConsumerFactory<String, HotelResponseDTO> consumerFactory() {
	 * Map<String, Object> config = new HashMap<String, Object>();
	 * config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	 * config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
	 * config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class);
	 * config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
	 * JsonSerializer.class); return new DefaultKafkaConsumerFactory<>(config); }
	 * 
	 * @Bean public ConcurrentKafkaListenerContainerFactory<String,
	 * HotelResponseDTO> listenerFactory() {
	 * ConcurrentKafkaListenerContainerFactory<String, HotelResponseDTO>
	 * listenerFactory = new ConcurrentKafkaListenerContainerFactory<String,
	 * HotelResponseDTO>(); listenerFactory.setConsumerFactory(consumerFactory());
	 * return listenerFactory; }
	 */
}
