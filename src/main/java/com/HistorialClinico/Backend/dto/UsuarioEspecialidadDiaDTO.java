package com.HistorialClinico.Backend.dto;

import java.time.LocalTime;

public class UsuarioEspecialidadDiaDTO {
    private Long usuarioId; // Nuevo campo para almacenar el ID del usuario
    private String usuario;
    private String especialidad;
    private String turno;
    private LocalTime horario;
    private String dia;

    // Constructor actualizado para incluir usuarioId
    public UsuarioEspecialidadDiaDTO(Long usuarioId, String usuario, String especialidad, String turno, LocalTime horario, String dia) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.especialidad = especialidad;
        this.turno = turno;
        this.horario = horario;
        this.dia = dia;
    }

    // Getters y Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
