package com.example.consumidor_horarios.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.file.*;
import java.time.LocalDateTime;

@Service
public class HorariosConsumer {

    @RabbitListener(queues = "cola-horarios-rutas")
    public void recibir(String msg) throws Exception {
        String json = """
        {
          "mensaje": "%s",
          "fecha": "%s"
        }
        """.formatted(msg, LocalDateTime.now());

        Path path = Paths.get("data/horarios-" + System.currentTimeMillis() + ".json");
        Files.createDirectories(path.getParent());
        Files.writeString(path, json);

        System.out.println("Archivo JSON creado: " + path.toAbsolutePath());
    }
}
