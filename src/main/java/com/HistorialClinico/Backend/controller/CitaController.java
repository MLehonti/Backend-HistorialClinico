package com.HistorialClinico.Backend.controller;

import com.HistorialClinico.Backend.dto.CitaDTO;
import com.HistorialClinico.Backend.dto.CitaResponseDTO;
import com.HistorialClinico.Backend.model.Cita;
import com.HistorialClinico.Backend.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private static final Logger log = LoggerFactory.getLogger(CitaController.class);

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearCita(@Valid @RequestBody CitaDTO citaDTO) {
        if (citaDTO.getUsuarioId() == null) {
            log.warn("Usuario ID es nulo");
            return ResponseEntity.badRequest().body("Error: Usuario ID es requerido");
        }
        if (citaDTO.getMedicoId() == null) {
            log.warn("Médico ID es nulo");
            return ResponseEntity.badRequest().body("Error: Médico ID es requerido");
        }
        if (citaDTO.getEspecialidadId() == null) {
            log.warn("Especialidad ID es nulo");
            return ResponseEntity.badRequest().body("Error: Especialidad ID es requerido");
        }
        if (citaDTO.getTurnoId() == null) {
            log.warn("Turno ID es nulo");
            return ResponseEntity.badRequest().body("Error: Turno ID es requerido");
        }
        if (citaDTO.getDiaId() == null) {
            log.warn("Día ID es nulo");
            return ResponseEntity.badRequest().body("Error: Día ID es requerido");
        }
        if (citaDTO.getHorario() == null) {
            log.warn("Horario es nulo");
            return ResponseEntity.badRequest().body("Error: Horario es requerido");
        }
        if (citaDTO.getNombreUsuarioLogeado() == null) {
            log.warn("Nombre del usuario logueado es nulo");
            return ResponseEntity.badRequest().body("Error: Nombre del usuario logueado es requerido");
        }

        Cita nuevaCita = citaService.crearCita(citaDTO);
        return ResponseEntity.ok(nuevaCita);
    }



    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<CitaResponseDTO>> obtenerCitasPorUsuarioId(@PathVariable Long usuarioId) {
        List<CitaResponseDTO> citas = citaService.obtenerCitasPorUsuarioId(usuarioId);
        return ResponseEntity.ok(citas);
    }


    // CitaController.java
    @GetMapping("/citas-por-medico/{medicoId}")
    public ResponseEntity<List<CitaDTO>> obtenerCitasPorMedico(@PathVariable Long medicoId) {
        List<Cita> citas = citaService.obtenerCitasPorMedico(medicoId);
        List<CitaDTO> citasDTO = citas.stream().map(cita -> {
            CitaDTO dto = new CitaDTO();
            dto.setHorario(cita.getHorario());
            dto.setNombreUsuarioLogeado(cita.getNombreUsuarioLogeado());
            // map other fields as needed
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(citasDTO);
    }


    @GetMapping("/medico/{medicoId}")
    public ResponseEntity<List<CitaResponseDTO>> obtenerCitasPorMedicoId(@PathVariable Long medicoId) {
        List<CitaResponseDTO> citas = citaService.obtenerCitasPorMedicoId(medicoId);
        return ResponseEntity.ok(citas);
    }

}
