package com.arquitecturasoftware.apiescuelaenlinea.repository;

import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByIdentificacion(String identificacion);
    Optional<Usuario> findByCorreo(String correo);
    Boolean existsByIdentificacion(String identificacion);
    Boolean existsByCorreo(String correo);
}
