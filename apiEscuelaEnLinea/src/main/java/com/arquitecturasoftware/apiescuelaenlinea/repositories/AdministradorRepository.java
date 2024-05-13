package com.arquitecturasoftware.apiescuelaenlinea.repositories;

import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}