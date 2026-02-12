package com.example.consumidor_horarios.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue colaHorarios() {
        return new Queue("cola-horarios-rutas", true);
    }
}