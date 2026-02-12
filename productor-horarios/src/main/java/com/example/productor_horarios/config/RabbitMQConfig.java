package com.example.productor_horarios.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue colaUbicaciones() {
        return new Queue("cola-ubicaciones-vehiculos", true);
    }

    @Bean
    public Queue colaHorarios() {
        return new Queue("cola-horarios-rutas", true);
    }
}