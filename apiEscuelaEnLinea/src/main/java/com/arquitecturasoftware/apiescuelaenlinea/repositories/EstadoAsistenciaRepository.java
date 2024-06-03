package com.arquitecturasoftware.apiescuelaenlinea.repositories;

import com.arquitecturasoftware.apiescuelaenlinea.model.entities.EstadoAsistencia;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.EEstadoAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EstadoAsistenciaRepository extends JpaRepository<EstadoAsistencia, Long> {
    Optional<EstadoAsistencia> findByEstado(EEstadoAsistencia estado);
    boolean existsByEstado(EEstadoAsistencia estado);
}
