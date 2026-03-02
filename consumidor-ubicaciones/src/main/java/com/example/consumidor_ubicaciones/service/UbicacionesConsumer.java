package com.example.consumidor_ubicaciones.service;

import com.example.consumidor_ubicaciones.dto.UbicacionDTO;
import com.example.consumidor_ubicaciones.dto.HorarioDTO;
import com.example.consumidor_ubicaciones.model.UbicacionEntity;
import com.example.consumidor_ubicaciones.repository.UbicacionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UbicacionesConsumer {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private final ObjectMapper mapper = new ObjectMapper()
        .findAndRegisterModules();

    @KafkaListener(
            topics = "Ubicaciones",
            groupId = "grupo-ubicaciones",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumir(String mensaje) {

        try {

            System.out.println("Mensaje recibido desde Kafka: " + mensaje);

            // Convertir JSON → DTO
            UbicacionDTO dto = mapper.readValue(mensaje, UbicacionDTO.class);

            // Guardar en Oracle
            UbicacionEntity entity = new UbicacionEntity();
            entity.setVehiculoId(dto.getVehiculoId());
            entity.setLatitud(dto.getLatitud());
            entity.setLongitud(dto.getLongitud());
            entity.setFechaHora(LocalDateTime.now());
            entity.setCreadoEn(LocalDateTime.now());

            ubicacionRepository.save(entity);

            System.out.println("Ubicación guardada en Oracle");

            // Crear horario automáticamente
            HorarioDTO horario = new HorarioDTO();
            horario.setVehiculoId(dto.getVehiculoId());
            horario.setEstado("En ruta");
            horario.setHoraEstimada(LocalDateTime.now().plusMinutes(10));
            horario.setFechaHora(LocalDateTime.now());

            // Publicar en topic Horarios
            kafkaTemplate.send("Horarios", horario);
            

            System.out.println("Horario enviado a Kafka");

        } catch (Exception e) {

            System.out.println("Error procesando ubicación");
            e.printStackTrace();
        }
    }
}