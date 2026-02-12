package com.example.productor_ubicaciones.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue colaUbicaciones() {
        return new Queue("cola-ubicaciones-vehiculos", true);
    }

}