package com.example.consumidor_horarios.service;

import com.example.consumidor_horarios.dto.HorarioDTO;
import com.example.consumidor_horarios.model.HorarioEntity;
import com.example.consumidor_horarios.repository.HorarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HorariosConsumer {

    @Autowired
    private HorarioRepository horarioRepository;

    private final ObjectMapper mapper = new ObjectMapper()
            .findAndRegisterModules();

    @KafkaListener(topics = "Horarios", groupId = "grupo-horarios")
    public void consumir(String mensaje) {

        try {
            System.out.println("Mensaje recibido: " + mensaje);

            HorarioDTO dto = mapper.readValue(mensaje, HorarioDTO.class);

            HorarioEntity entity = new HorarioEntity();
            entity.setVehiculoId(dto.getVehiculoId());
            entity.setEstado(dto.getEstado());
            entity.setHoraEstimada(dto.getHoraEstimada());
            entity.setFechaHora(dto.getFechaHora());   // 🔥 FALTABA ESTO
            entity.setCreadoEn(LocalDateTime.now());

            HorarioEntity guardado = horarioRepository.save(entity);

            System.out.println("Horario guardado con ID: " + guardado.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}