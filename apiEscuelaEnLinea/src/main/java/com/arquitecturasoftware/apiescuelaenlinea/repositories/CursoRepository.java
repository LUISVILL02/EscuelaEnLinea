package com.arquitecturasoftware.apiescuelaenlinea.repositories;

import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
