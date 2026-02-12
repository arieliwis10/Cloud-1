package com.example.consumidor_ubicaciones.controller;

import com.example.consumidor_ubicaciones.model.UbicacionEntity;
import com.example.consumidor_ubicaciones.repository.UbicacionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionesQueryController {

    private final UbicacionRepository repo;

    public UbicacionesQueryController(UbicacionRepository repo) {
        this.repo = repo;
    }

    // 🔎 GET todos
    @GetMapping
    public List<UbicacionEntity> listar() {
        return repo.findAll();
    }

    // 🔎 GET por ID
    @GetMapping("/{id}")
    public UbicacionEntity obtener(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));
    }

    // ✏️ PUT actualizar
    @PutMapping("/{id}")
    public UbicacionEntity actualizar(@PathVariable Long id, @RequestBody UbicacionEntity data) {
        UbicacionEntity u = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));

        u.setContenido(data.getContenido());
        return repo.save(u);
    }

    // 🗑 DELETE
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "Ubicación eliminada: " + id;
    }
}
