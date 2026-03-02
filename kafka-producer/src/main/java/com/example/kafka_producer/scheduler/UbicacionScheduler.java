package com.example.kafka_producer.scheduler;

import com.example.kafka_producer.dto.UbicacionDTO;
import com.example.kafka_producer.service.KafkaProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UbicacionScheduler {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Scheduled(fixedRate = 60000) // cada 1 minuto
    public void generarUbicacion() {

        UbicacionDTO dto = new UbicacionDTO();

        dto.setVehiculoId("BUS-" + (int)(Math.random() * 5));
        dto.setLatitud(-33.45 + Math.random() / 100);
        dto.setLongitud(-70.66 + Math.random() / 100);
        dto.setFechaHora(LocalDateTime.now());

        kafkaProducerService.enviarUbicacion(dto);

        System.out.println("Ubicación generada automáticamente");
    }
}