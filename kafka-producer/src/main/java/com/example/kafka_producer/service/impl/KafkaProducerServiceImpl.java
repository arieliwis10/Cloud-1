package com.example.kafka_producer.service.impl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka_producer.config.KafkaProducerConfig;
import com.example.kafka_producer.dto.UbicacionDTO;
import com.example.kafka_producer.service.KafkaProducerService;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, UbicacionDTO> kafkaTemplate;

	@Override
	public void enviarUbicacion(UbicacionDTO ubicacion) {

		System.out.println("Enviando ubicación a Kafka: " + ubicacion);

		kafkaTemplate.send(KafkaProducerConfig.TOPIC, ubicacion);
//		kafkaTemplate.send(KafkaProducerConfig.TOPIC, 1, "", ubicacion);
	}
}
