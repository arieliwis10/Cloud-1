package com.example.productor_ubicaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionesController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String enviar(@RequestParam String ubicacion) {
        rabbitTemplate.convertAndSend("cola-ubicaciones-vehiculos", ubicacion);
        return "Ubicación enviada: " + ubicacion;
    }
}
