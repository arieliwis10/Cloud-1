package com.example.consumidor_ubicaciones.dto;

import java.time.LocalDateTime;

public class HorarioDTO {

    private String vehiculoId;
    private String estado;
    private LocalDateTime horaEstimada;
    private LocalDateTime fechaHora;

    public HorarioDTO() {}

    public String getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(String vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getHoraEstimada() {
        return horaEstimada;
    }

    public void setHoraEstimada(LocalDateTime horaEstimada) {
        this.horaEstimada = horaEstimada;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}