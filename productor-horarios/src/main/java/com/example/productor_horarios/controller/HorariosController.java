package com.example.productor_horarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/horarios")
public class HorariosController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String enviar(@RequestParam String cambio) {
        rabbitTemplate.convertAndSend("cola-horarios-rutas", cambio);
        return "Horario/Ruta enviado: " + cambio;
    }
}
