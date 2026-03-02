package com.example.kafka_producer.dto;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UbicacionDTO {

    private String vehiculoId;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fechaHora;
}