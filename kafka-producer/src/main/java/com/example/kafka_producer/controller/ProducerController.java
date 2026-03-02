package com.example.kafka_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka_producer.dto.UbicacionDTO;
import com.example.kafka_producer.service.KafkaProducerService;

@RestController
public class ProducerController {

	@Autowired
	private KafkaProducerService producerService;

	@PostMapping("/ubicacion")
public ResponseEntity<String> enviar(@RequestBody UbicacionDTO dto) {
    producerService.enviarUbicacion(dto);
    return ResponseEntity.ok("Ubicación enviada");
}
}
