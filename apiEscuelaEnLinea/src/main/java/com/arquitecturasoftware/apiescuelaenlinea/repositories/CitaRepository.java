package com.arquitecturasoftware.apiescuelaenlinea.repositories;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Cita;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> getCitasByProfesor_IdUser(Long idProfesor);
    List<Cita> getCitasByAcudiente_IdUser(Long idAcudiente);
    List<Cita> getCitasByEstadoCita_IdEstadoCita(Long idEstadoCita);

}
