package com.arquitecturasoftware.apiescuelaenlinea.repositories;

import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Acudiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcudienteRepository extends JpaRepository<Acudiente, Long> {
    Optional<Acudiente> findByNombreAndApellido(String nombre, String apellido);
    Optional<Acudiente> findByIdentificacion(String identificacion);
}
