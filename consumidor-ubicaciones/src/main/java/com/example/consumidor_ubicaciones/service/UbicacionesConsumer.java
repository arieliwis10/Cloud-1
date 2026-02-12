package com.example.consumidor_ubicaciones.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consumidor_ubicaciones.model.UbicacionEntity;
import com.example.consumidor_ubicaciones.repository.UbicacionRepository;

import java.time.LocalDateTime;

@Service
public class UbicacionesConsumer {

    @Autowired
    private UbicacionRepository repo;

    @RabbitListener(queues = "cola-ubicaciones-vehiculos")
    public void recibir(String msg) {
        UbicacionEntity u = new UbicacionEntity();
        u.setContenido(msg);
        u.setFecha(LocalDateTime.now());

        repo.save(u);

        System.out.println("Guardado en Oracle: " + msg);
    }
}
