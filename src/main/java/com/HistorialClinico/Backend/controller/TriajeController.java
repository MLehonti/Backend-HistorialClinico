package com.HistorialClinico.Backend.controller;

import com.HistorialClinico.Backend.dto.TriajeDTO;
import com.HistorialClinico.Backend.dto.TriajeResponseDTO;
import com.HistorialClinico.Backend.model.Triaje;
import com.HistorialClinico.Backend.service.TriajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/triajes")
public class TriajeController {

    private final TriajeService triajeService;

    @Autowired
    public TriajeController(TriajeService triajeService) {
        this.triajeService = triajeService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Triaje> crearTriaje(@Valid @RequestBody TriajeDTO triajeDTO) {
        Triaje nuevoTriaje = triajeService.crearTriaje(triajeDTO);
        return ResponseEntity.ok(nuevoTriaje);
    }



    @GetMapping("/todos")
    public ResponseEntity<List<TriajeResponseDTO>> obtenerTodosLosTriajes() {
        List<TriajeResponseDTO> triajes = triajeService.obtenerTodosLosTriajes();
        return ResponseEntity.ok(triajes);
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<TriajeResponseDTO>> obtenerTriajesPorPacienteId(@PathVariable Long pacienteId) {
        List<TriajeResponseDTO> triajes = triajeService.obtenerTriajesPorPacienteId(pacienteId);
        return ResponseEntity.ok(triajes);
    }




}
