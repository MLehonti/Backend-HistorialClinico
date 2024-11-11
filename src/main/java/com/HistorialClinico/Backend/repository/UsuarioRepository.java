//package com.HistorialClinico.Backend.repository;
//
//import com.HistorialClinico.Backend.model.Especialidad;
//import com.HistorialClinico.Backend.model.Usuario;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//    Optional<Usuario> findByUsername(String username);
//
//    @Query("SELECT u FROM Usuario u JOIN u.roles r WHERE r.nombre = ?1")
//    List<Usuario> findByRolesNombreRol(String nombreRol);
//
//}

// UsuarioRepository.java
package com.HistorialClinico.Backend.repository;

import com.HistorialClinico.Backend.model.Especialidad;
import com.HistorialClinico.Backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

    @Query("SELECT u FROM Usuario u JOIN u.roles r WHERE r.nombre = ?1")
    List<Usuario> findByRolesNombreRol(String nombreRol);

    // Agrega este método
    @Query("SELECT u.especialidades FROM Usuario u WHERE u.id = :usuarioId")
    List<Especialidad> findEspecialidadesByUsuarioId(@Param("usuarioId") Long usuarioId);
}
