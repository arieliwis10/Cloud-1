package com.example.kafka_producer.service;

import com.example.kafka_producer.dto.UbicacionDTO;

public interface KafkaProducerService {

	void enviarUbicacion(UbicacionDTO ubicacion);
}
