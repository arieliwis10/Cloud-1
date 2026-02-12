package com.example.consumidor_ubicaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.consumidor_ubicaciones.model.UbicacionEntity;

public interface UbicacionRepository extends JpaRepository<UbicacionEntity, Long> {
}
