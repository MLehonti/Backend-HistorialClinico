package com.HistorialClinico.Backend.service;

import com.HistorialClinico.Backend.dto.CitaDTO;
import com.HistorialClinico.Backend.dto.CitaResponseDTO;
import com.HistorialClinico.Backend.model.*;
import com.HistorialClinico.Backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EspecialidadRepository especialidadRepository;
    private final TurnoRepository turnoRepository;
    private final DiaRepository diaRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository,
                       UsuarioRepository usuarioRepository,
                       EspecialidadRepository especialidadRepository,
                       TurnoRepository turnoRepository,
                       DiaRepository diaRepository) {
        this.citaRepository = citaRepository;
        this.usuarioRepository = usuarioRepository;
        this.especialidadRepository = especialidadRepository;
        this.turnoRepository = turnoRepository;
        this.diaRepository = diaRepository;
    }

    public Cita crearCita(CitaDTO citaDTO) {
        Cita cita = new Cita();

        Usuario usuario = usuarioRepository.findById(citaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Usuario medico = usuarioRepository.findById(citaDTO.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));
        Especialidad especialidad = especialidadRepository.findById(citaDTO.getEspecialidadId())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
        Turno turno = turnoRepository.findById(citaDTO.getTurnoId())
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        Dia dia = diaRepository.findById(citaDTO.getDiaId())
                .orElseThrow(() -> new RuntimeException("Día no encontrado"));

        cita.setUsuario(usuario);
        cita.setMedico(medico); // Asignación del médico
        cita.setEspecialidad(especialidad);
        cita.setTurno(turno);
        cita.setDia(dia);
        cita.setHorario(citaDTO.getHorario());
        cita.setNombreUsuarioLogeado(citaDTO.getNombreUsuarioLogeado());

        return citaRepository.save(cita);
    }


    public List<CitaResponseDTO> obtenerCitasPorUsuarioId(Long usuarioId) {
        return citaRepository.findCitasByUsuarioId(usuarioId);
    }

    public List<Cita> obtenerCitasPorMedico(Long medicoId) {
        return citaRepository.findByMedicoId(medicoId);
    }


    public List<CitaResponseDTO> obtenerCitasPorMedicoId(Long medicoId) {
        return citaRepository.findCitasByMedicoId(medicoId);
    }


}
