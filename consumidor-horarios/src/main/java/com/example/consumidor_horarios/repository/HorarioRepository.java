package com.example.consumidor_horarios.repository;

import com.example.consumidor_horarios.model.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<HorarioEntity, Long> {
}