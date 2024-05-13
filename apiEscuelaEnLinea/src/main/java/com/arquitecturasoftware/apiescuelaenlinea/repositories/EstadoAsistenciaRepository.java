package com.arquitecturasoftware.apiescuelaenlinea.repositories;

import com.arquitecturasoftware.apiescuelaenlinea.model.entities.EstadoAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoAsistenciaRepository extends JpaRepository<EstadoAsistencia, Long> {
}
