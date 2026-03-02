package com.example.consumidor_ubicaciones.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "UBICACIONES")
public class UbicacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ubicacion_seq")
    @SequenceGenerator(
            name = "ubicacion_seq",
            sequenceName = "UBICACION_SEQ",
            allocationSize = 1
    )
    @Column(name = "ID")
    private Long id;

    @Column(name = "VEHICULO_ID", nullable = false, length = 50)
    private String vehiculoId;

    @Column(name = "LATITUD", nullable = false)
    private Double latitud;

    @Column(name = "LONGITUD", nullable = false)
    private Double longitud;

    @Column(name = "FECHA_HORA")
    private LocalDateTime fechaHora;

    @Column(name = "CREADO_EN")
    private LocalDateTime creadoEn;

    // Constructor vacío obligatorio para JPA
    public UbicacionEntity() {}

    // ===== Getters y Setters =====

    public Long getId() {
        return id;
    }

    public String getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(String vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}