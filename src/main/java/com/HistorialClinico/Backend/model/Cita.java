package com.HistorialClinico.Backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference("usuario-cita")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false) // Nuevo campo para el médico
    @JsonBackReference("medico-cita")
    private Usuario medico;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    @JsonBackReference("especialidad-cita")
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "turno_id", nullable = false)
    @JsonBackReference("turno-cita")
    private Turno turno;

    @ManyToOne
    @JoinColumn(name = "dia_id", nullable = false)
    @JsonBackReference("dia-cita")
    private Dia dia;

    @Column(nullable = false)
    private String horario;

    @Column(name = "nombre_usuario_logeado", nullable = false)
    private String nombreUsuarioLogeado;

    // Constructor vacío
    public Cita() {}

    // Constructor con parámetros
    public Cita(Usuario usuario, Usuario medico, Especialidad especialidad, Turno turno, Dia dia, String horario, String nombreUsuarioLogeado) {
        this.usuario = usuario;
        this.medico = medico;
        this.especialidad = especialidad;
        this.turno = turno;
        this.dia = dia;
        this.horario = horario;
        this.nombreUsuarioLogeado = nombreUsuarioLogeado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombreUsuarioLogeado() {
        return nombreUsuarioLogeado;
    }

    public void setNombreUsuarioLogeado(String nombreUsuarioLogeado) {
        this.nombreUsuarioLogeado = nombreUsuarioLogeado;
    }
}
