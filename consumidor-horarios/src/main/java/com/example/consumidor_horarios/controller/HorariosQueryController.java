package com.example.consumidor_horarios.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/horarios")
public class HorariosQueryController {

    // Usa tu property si la tienes, si no, deja "./data"
    @Value("${horarios.output.dir:./data}")
    private String outputDir;

    // ✅ GET: listar archivos JSON
    @GetMapping
    public List<String> listar() throws IOException {
        Path dir = Paths.get(outputDir);

        if (!Files.exists(dir)) {
            return List.of();
        }

        return Files.list(dir)
                .filter(p -> p.toString().endsWith(".json"))
                .map(p -> p.getFileName().toString())
                .collect(Collectors.toList());
    }

    // ✅ GET: leer contenido de un JSON
    @GetMapping("/{nombre}")
    public String leer(@PathVariable String nombre) throws IOException {
        Path file = Paths.get(outputDir, nombre);

        if (!Files.exists(file)) {
            throw new RuntimeException("Archivo no encontrado: " + nombre);
        }

        return Files.readString(file);
    }

    // ✅ PUT: sobrescribir un JSON (para demostrar actualización)
    @PutMapping("/{nombre}")
    public String actualizar(@PathVariable String nombre, @RequestBody String nuevoContenido) throws IOException {
        Path file = Paths.get(outputDir, nombre);

        if (!Files.exists(file)) {
            throw new RuntimeException("Archivo no encontrado: " + nombre);
        }

        Files.writeString(file, nuevoContenido, StandardOpenOption.TRUNCATE_EXISTING);
        return "Archivo actualizado: " + nombre;
    }

    // ✅ DELETE: borrar un JSON
    @DeleteMapping("/{nombre}")
    public String eliminar(@PathVariable String nombre) throws IOException {
        Path file = Paths.get(outputDir, nombre);

        if (!Files.exists(file)) {
            throw new RuntimeException("Archivo no encontrado: " + nombre);
        }

        Files.delete(file);
        return "Archivo eliminado: " + nombre;
    }
}
