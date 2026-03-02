package com.example.consumidor_horarios.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "HORARIOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "horario_seq")
    @SequenceGenerator(
            name = "horario_seq",
            sequenceName = "HORARIO_SEQ",
            allocationSize = 1
    )
    @Column(name = "ID")
    private Long id;

    @Column(name = "VEHICULO_ID", nullable = false)
    private String vehiculoId;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "FECHA_HORA")
    private LocalDateTime fechaHora;

    @Column(name = "HORA_ESTIMADA")
    private LocalDateTime horaEstimada;

    @Column(name = "CREADO_EN")
    private LocalDateTime creadoEn;
}