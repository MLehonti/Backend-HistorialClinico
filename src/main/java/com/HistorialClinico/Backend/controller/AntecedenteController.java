package com.HistorialClinico.Backend.controller;

import com.HistorialClinico.Backend.dto.AntecedenteRequestDTO;
import com.HistorialClinico.Backend.model.Antecedente;
import com.HistorialClinico.Backend.service.AntecedenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antecedentes")
public class AntecedenteController {

    @Autowired
    private AntecedenteService antecedenteService;

    @PostMapping("/crear")
    public ResponseEntity<Antecedente> crearAntecedente(@RequestBody AntecedenteRequestDTO antecedenteDTO) {
        Antecedente nuevoAntecedente = antecedenteService.crearAntecedente(antecedenteDTO);
        return ResponseEntity.ok(nuevoAntecedente);
    }


    //MUESTRA TODOS LOS ANTECEDENTES QUE HIZO EL MEDICO MEDIANTE EL USAURIO ID
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Antecedente>> obtenerAntecedentesPorUsuarioId(@PathVariable Long usuarioId) {
        List<Antecedente> antecedentes = antecedenteService.obtenerAntecedentesPorUsuarioId(usuarioId);
        return ResponseEntity.ok(antecedentes);
    }


    // Endpoint para obtener antecedentes por pacienteId
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Antecedente>> obtenerAntecedentesPorPacienteId(@PathVariable Long pacienteId) {
        List<Antecedente> antecedentes = antecedenteService.obtenerAntecedentesPorPacienteId(pacienteId);
        return ResponseEntity.ok(antecedentes);
    }
}
