package com.arquitecturasoftware.apiescuelaenlinea.repositories;

import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservacionRepository extends JpaRepository<Observacion, Long> {
}
