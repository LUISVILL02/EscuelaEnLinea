package com.arquitecturasoftware.apiescuelaenlinea.service;


import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CitaGDto;

import java.util.List;
import java.util.Optional;

public interface CitaService {
    List<CitaEDto> findAll();
    Optional<CitaEDto> findById(Long id);
    List<CitaEDto> findCitasByProfesor(Long idProfesor);
    List<CitaEDto> findCitasByAcudiente(Long idAcudiente);
    CitaEDto save(CitaGDto citaGDto);
    List<CitaEDto> findCitasByEstadoCita(Long idEstadoCita);
    String updateEstadoCita(Long idCita, Long idEstadoCita);

}
