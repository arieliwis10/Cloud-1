package com.example.consumidor_ubicaciones.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UbicacionDTO {

    private String vehiculoId;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fechaHora;
}